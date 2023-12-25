package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Employee;
import top.sakta.hrmsys.domain.User;
import top.sakta.hrmsys.service.EmployeeService;
import top.sakta.hrmsys.service.UserService;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 档案控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */


@RestController
@RequestMapping("/api/v1/employee")
@Tag(name = "档案接口模块")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @SaCheckPermission("employee.all")
    @Operation(summary = "获取档案列表接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return SaResult.ok("获取成功").setData(employees);
    }

    @SaCheckPermission("employee.get")
    @Operation(summary = "根据档案编号获取详细信息接口", description = "根据档案编号eID获取档案，参数为eID")
    @GetMapping("/get/{eID}")
    public SaResult getEmployee(@PathVariable String eID) {
        Employee employee = employeeService.getEmployeeByID(eID);
        if(employee == null) return SaResult.error("档案不存在");
        return SaResult.ok("获取成功").setData(employee);
    }

    @SaCheckPermission("employee.get")
    @Operation(summary = "根据档案状态获取详细信息接口", description = "根据档案状态eStatus获取档案，参数为eStatus")
    @GetMapping("/getByStatus/{eStatus}")
    public SaResult getEmployee(@PathVariable Integer eStatus) {
        List<Employee> employees = employeeService.getEmployeesByStatus(eStatus);
        return SaResult.ok("获取成功").setData(employees);
    }

    @SaCheckPermission("employee.add")
    @Operation(summary = "新增档案接口", description = "json数据，看档案实体类，eRecoders、eID参数可无")
    @PostMapping("/add")
    public SaResult addEmployee(@Validated @RequestBody Employee employee) {
        String ID = "";
        employee.setERecodDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(employee.getERecodDate());
        ID += calendar.get(Calendar.YEAR) + employee.getEL1InstID() + employee.getEL2InstID() + employee.getEL3InstID().substring(employee.getEL3InstID().length()-2);
        int count = employeeService.getEmployeeLikeID(ID).size() + 1;
        if(count >= 100){
            return SaResult.error("添加失败：该机构今年的档案编号已满");
        }
        ID += String.format("%02d",count);
        User user = userService.getUserById(StpUtil.getLoginIdAsString());
        employee.setERecoders(user.getUName());
        employee.setEID(ID);
        employeeService.insertEmployee(employee);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("employee.update")
    @Operation(summary = "修改档案接口", description = "json数据，看档案实体类，eStatus可无")
    @PutMapping("/update")
    public SaResult updateEmployee(@Validated @RequestBody Employee employee) {
        if(employeeService.getEmployeeByID(employee.getEID()) == null){
            return SaResult.error("修改失败，查无此档案");
        }
        employee.setEStatus(0);
        employeeService.updateEmployee(employee);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("employee.delete")
    @Operation(summary = "删除档案接口", description = "根据档案编号eID删除档案，参数为eID")
    @DeleteMapping("/delete/{eID}")
    public SaResult deleteEmployee(@PathVariable String eID){
        Employee employee = employeeService.getEmployeeByID(eID);
        if(employee == null){
            return SaResult.error("删除失败，查无此档案");
        }
        if(employee.getEStatus() == 0){
            return SaResult.error("删除失败，该档案是未审核状态");
        }
        employeeService.updateEmployeeStatus(eID,-1);
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("employee.recover")
    @Operation(summary = "恢复档案接口", description = "根据档案编号eID恢复档案，参数为eID")
    @PutMapping("/recover/{eID}")
    public SaResult recoverEmployee(@PathVariable String eID){
        Employee employee = employeeService.getEmployeeByID(eID);
        if(employee == null){
            return SaResult.error("恢复失败，查无此档案");
        }
        if(employee.getEStatus() != -1){
            return SaResult.error("恢复失败，该档案不是未删除状态");
        }
        employeeService.updateEmployeeStatus(eID,0);
        return SaResult.ok("恢复成功");
    }

    @SaCheckPermission("employee.approved")
    @Operation(summary = "通过档案编号eID审核档案接口", description = "根据档案编号eID审核档案，参数为eID")
    @PutMapping("/approvedByID/{eID}")
    public SaResult approvedEmployeeByID(@PathVariable String eID){
        Employee employee = employeeService.getEmployeeByID(eID);
        if(employee == null){
            return SaResult.error("审核失败，查无此档案");
        }
        if(employee.getEStatus() != 0){
            return SaResult.error("审核失败，该档案不是未审核状态");
        }
        employeeService.updateEmployeeStatus(eID,0);
        return SaResult.ok("审核成功");
    }

    @SaCheckPermission("employee.approved")
    @Operation(summary = "审核档案接口", description = "json数据，看档案实体类，eStatus可无")
    @PutMapping("/approved")
    public SaResult approvedEmployee(@Validated @RequestBody Employee employee) {
        Employee getEmployee = employeeService.getEmployeeByID(employee.getEID());
        if(getEmployee == null){
            return SaResult.error("审核失败，查无此档案");
        }
        if(getEmployee.getEStatus() != 0){
            return SaResult.error("审核失败，该档案不是未审核状态");
        }
        employee.setEStatus(1);
        employeeService.updateEmployee(employee);
        return SaResult.ok("审核成功");
    }

    @SaCheckPermission("employee.get")
    @Operation(summary = "多条件查询档案接口", description = "根据条件查询档案，参数为eL1InstID、eL2InstID、eL3InstID、ePositionCategory、ePositionName、StartRecodDate、EndRecodDate，所有参数可无")
    @PostMapping("/getByConditions")
    public SaResult getEmployeesByConditions(String eL1InstID, String eL2InstID, String eL3InstID, String ePositionCategory, String ePositionName, @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date StartRecodDate,@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date EndRecodDate){
        List<Employee> employees = employeeService.getEmployeesByConditions(eL1InstID,eL2InstID,eL3InstID,ePositionCategory,ePositionName,StartRecodDate,EndRecodDate);
        return SaResult.ok("查询成功").setData(employees);
    }
}
