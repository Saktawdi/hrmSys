package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Salary;
import top.sakta.hrmsys.service.SalaryService;

import java.util.List;

/**
 * 薪资标准控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月23日
 */

@RestController
@RequestMapping("/api/v1/salary")
@Tag(name = "薪资标准接口模块")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @SaCheckPermission("salary.all")
    @Operation(summary = "获取薪资标准列表接口", description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAllSalaries() {
        List<Salary> salarys = salaryService.getAllSalaries();
        return SaResult.ok("获取成功").setData(salarys);
    }

    @SaCheckPermission("salary.get")
    @Operation(summary = "根据薪资标准编号获取详细信息接口", description = "根据薪资标准编号sID获取薪资标准，参数为sID")
    @GetMapping("/get/{sID}")
    public SaResult getSalary(@PathVariable Integer sID) {
        Salary salary = salaryService.getSalaryByID(sID);
        if(salary == null) return SaResult.error("薪资标准不存在");
        return SaResult.ok("获取成功").setData(salary);
    }

    @SaCheckPermission("salary.add")
    @Operation(summary = "新增薪资标准接口", description = "json数据，看薪资标准实体类，全属性必须")
    @PostMapping("/addSalary")
    public SaResult addSalary(@Validated @RequestBody Salary salary) {
        if(salaryService.getSalaryByID(salary.getSID()) != null) {
            return SaResult.error("薪资标准已存在");
        }
        salaryService.insertSalary(salary);
        return SaResult.ok("添加成功");
    }

    @SaCheckPermission("salary.update")
    @Operation(summary = "修改薪资标准接口", description = "json数据，看薪资标准实体类，全属性必须")
    @PutMapping("/update")
    public SaResult updateSalary(@Validated @RequestBody Salary salary) {
        if(salaryService.getSalaryByID(salary.getSID()) == null){
            return SaResult.error("修改失败，查无此薪资标准");
        }
        salaryService.updateSalary(salary);
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("salary.delete")
    @Operation(summary = "删除薪资标准接口", description = "根据薪资标准编号sID删除薪资标准，参数为sID")
    @DeleteMapping("/delete/{sID}")
    public SaResult deleteSalary(@PathVariable Integer sID){
        if(salaryService.getSalaryByID(sID) == null){
            return SaResult.error("删除失败，查无此薪资标准");
        }
        salaryService.deleteSalary(sID);
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("salary.get")
    @Operation(summary = "根据薪酬状态获取薪资标准列表接口", description = "根据薪资薪酬状态sStatus获取薪资标准，参数为sStatus")
    @GetMapping("/getByStatus/{sStatus}")
    public SaResult getAllSalaries(@PathVariable String sStatus) {
        List<Salary> salaries = salaryService.getSalaryByStatus(sStatus);
        return SaResult.ok("获取成功").setData(salaries);
    }
}
