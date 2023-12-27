package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Payroll;
import top.sakta.hrmsys.mapper.PayrollMapper;
import top.sakta.hrmsys.service.PayrollService;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollMapper payrollMapper;

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollMapper.getAllPayrolls();
    }
}
