package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Payroll;
import top.sakta.hrmsys.domain.ScheduledSended;
import top.sakta.hrmsys.service.PayrollService;
import top.sakta.hrmsys.service.ScheduledSendedService;

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

    @Autowired
    private ScheduledSendedService scheduledSendedService;

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取薪酬发放单接口", description = "无参数")
    @GetMapping("/getAllPayrolls")
    public SaResult getAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return SaResult.ok("查询成功").setData(payrolls);
    }

    @SaCheckPermission("bonus.add")
    @Operation(summary = "新增薪酬发放单接口", description = "json数据，看菜单实体类，pID、pStatus可无")
    @PostMapping("/addPayroll")
    public SaResult addPayroll(@RequestBody @Validated Payroll payroll) {
        payroll.setPID(null);
        payroll.setPStatus(0);
        payrollService.insertPayroll(payroll);
        return SaResult.ok("新增成功");
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取薪酬发放单接口", description = "无参数")
    @GetMapping("/getStaticPayrolls")
    public SaResult getStaticPayrolls() {
        List<Payroll> payrolls = payrollService.getAll();
        return SaResult.ok("查询成功").setData(payrolls);
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "根据状态获取薪酬发放单接口", description = "根据薪酬发放单状态pStatus查询")
    @GetMapping("/getStaticPayrollsByStatus/{pStatus}")
    public SaResult getStaticPayrollsByStatus(@PathVariable int pStatus) {
        List<Payroll> payrolls = payrollService.getPayrollsByStatus(pStatus);
        return SaResult.ok("查询成功").setData(payrolls);
    }

    @SaCheckPermission("bonus.update")
    @Operation(summary = "根据编号、状态修改薪酬发放单状态接口", description = "根据编号、状态修改薪酬发放单状态，参数为")
    @PutMapping("/updateStaticPayrollByID/{pID}/{pStatus}")
    public SaResult updateStaticPayrollsByID(@PathVariable int pID,@PathVariable int pStatus) {
        if(payrollService.updatePayrollStatus(pID,pStatus) < 1){
            return SaResult.error("修改失败");
        }
        return SaResult.ok("修改成功");
    }

    @SaCheckPermission("bonus.delete")
    @Operation(summary = "根据编号删除薪酬发放单接口", description = "根据编号删除薪酬发放单，参数为pID")
    @DeleteMapping("/deleteStaticPayroll/{pID}")
    public SaResult deleteStaticPayroll(@PathVariable int pID){
        if(payrollService.deletePayroll(pID) < 1){
            return SaResult.error("删除失败");
        }
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("bonus.get")
    @Operation(summary = "根据状态获取薪酬发放单接口", description = "无参数")
    @GetMapping("/getAllScheduledSendeds")
    public SaResult getAllScheduledSendeds(){
        List<ScheduledSended> scheduledSendeds = scheduledSendedService.getAllScheduledSendeds();
        return SaResult.ok("获取成功").setData(scheduledSendeds);
    }
}
