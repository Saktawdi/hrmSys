package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Employee;
import top.sakta.hrmsys.service.EmployeeService;

import java.util.List;

/**
 * 档案控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @SaCheckPermission("employee.list")
    @Operation(summary = "获取档案列表接口", description = "json数据，看档案实体类")
    @GetMapping("/list")
    public SaResult list() {
        List<Employee> employees = employeeService.getAllEmployees();
        return SaResult.ok("获取成功").setData(employees);
    }

    @SaCheckPermission("employee.query")
    @Operation(summary = "根据档案编号获取详细信息接口", description = "json数据，接收字符串数据")
    @GetMapping("/{eID}")
    public SaResult getInfo(@PathVariable String eID) {
        Employee employee = employeeService.getEmployeeByID(eID);
        if(employee == null) return SaResult.error("档案不存在");
        return SaResult.ok("获取成功").setData(employee);
    }

    @SaCheckPermission("employee.add")
    @Operation(summary = "新增档案接口", description = "json数据，看档案实体类，全属性必须")
    @PostMapping
    public SaResult add(@Validated @RequestBody Employee employee) {
        if(employeeService.getEmployeeByID(employee.getEID()) != null) {
            return SaResult.error("档案已存在");
        }
        employeeService.insertEmployee(employee);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("employee.edit")
    @Operation(summary = "修改档案接口", description = "json数据，看档案实体类，全属性必须")
    @PutMapping
    public SaResult edit(@Validated @RequestBody Employee employee) {
        if(employeeService.getEmployeeByID(employee.getEID()) == null){
            return SaResult.error("修改失败，查无此档案");
        }
        employeeService.updateEmployee(employee);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("employee.remove")
    @Operation(summary = "删除档案接口", description = "json数据，接收字符串数据")
    @DeleteMapping("/{eID}")
    public SaResult remove(@PathVariable String eID){
        if(employeeService.getEmployeeByID(eID) == null){
            return SaResult.error("删除失败，查无此档案");
        }
        employeeService.deleteEmployee(eID);
        return SaResult.ok("删除成功");
    }

}
