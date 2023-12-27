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

    @Override
    public int insertPayroll(Payroll payroll) {
        return payrollMapper.insertPayroll(payroll);
    }

    @Override
    public List<Payroll> getAll() {
        return payrollMapper.getAll();
    }

    @Override
    public List<Payroll> getPayrollsByStatus(int pStatus) {
        return payrollMapper.getPayrollsByStatus(pStatus);
    }

    @Override
    public int updatePayrollStatus(int pID, int pStatus) {
        return payrollMapper.updatePayrollStatus(pID,pStatus);
    }

    @Override
    public int deletePayroll(int pID) {
        return payrollMapper.deletePayroll(pID);
    }
}
