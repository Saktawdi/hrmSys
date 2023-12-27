package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Payroll;

import java.util.List;

/**
 * Mapper 薪酬发放单Service
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

public interface PayrollService {
    List<Payroll> getAllPayrolls();

    int insertPayroll(Payroll payroll);

    List<Payroll> getAll();

    List<Payroll> getPayrollsByStatus(int pStatus);

    int updatePayrollStatus(int pID,int pStatus);

    int deletePayroll(int pID);

}
