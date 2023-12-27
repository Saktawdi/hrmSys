package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakta.hrmsys.domain.Payslip;
import top.sakta.hrmsys.service.PayslipService;

import java.util.List;

@Tag(name = "工资单接口模块")
@RestController
@RequestMapping("/api/v1/salary")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @SaCheckPermission("bonus.get")
    @Operation(summary = "获取薪酬明细列表接口", description = "json数据，看薪资标准实体类，参数为三级机构编号L3InstID")
    @GetMapping("/getPayslips/{L3InstID}")
    public SaResult getAllPayrolls(@PathVariable String L3InstID){
        List<Payslip> payslips = payslipService.getPayslipsByL3InstID(L3InstID);
        return SaResult.ok("查询成功").setData(payslips);
    }
}
