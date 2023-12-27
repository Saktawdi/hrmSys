package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Payroll;
import top.sakta.hrmsys.service.PayrollService;

import java.util.List;

/**
 * 薪酬发放单控制器
 * @author  Quescc
 * @version 0.0.1
 * @date 2023年12月27日
 */

@Tag(name = "薪酬发放单接口模块")
@RestController
@RequestMapping("/api/v1/salary")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取薪酬发放单接口", description = "无参数")
    @GetMapping("/getAllPayrolls")
    public SaResult getAllPayrolls(){
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return SaResult.ok("查询成功").setData(payrolls);
    }

    @Operation(summary = "新增薪酬发放单接口", description = "json数据，看菜单实体类，pID、pStatus可无")
    @PostMapping("/addPayroll")
    public SaResult addPayroll(@RequestBody @Validated Payroll payroll){
        payroll.setPID(null);
        payroll.setPStatus(0);
        payrollService.insertPayroll(payroll);
        return SaResult.ok("新增成功");
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取薪酬发放单接口", description = "无参数")
    @GetMapping("/getStaticPayrolls")
    public SaResult getStaticPayrolls(){
        List<Payroll> payrolls = payrollService.getAll();
        return SaResult.ok("查询成功").setData(payrolls);
    }


}
