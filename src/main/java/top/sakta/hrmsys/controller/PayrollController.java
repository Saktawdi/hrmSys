package top.sakta.hrmsys.controller;


import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sakta.hrmsys.domain.Payroll;
import top.sakta.hrmsys.service.PayrollService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("/getAllPayrolls")
    public SaResult getAllPayrolls(){
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return SaResult.ok("查询成功").setData(payrolls);
    }
}
