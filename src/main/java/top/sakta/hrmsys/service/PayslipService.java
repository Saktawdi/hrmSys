package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Payslip;

import java.util.List;

public interface PayslipService {
    List<Payslip> getPayslipsByL3InstID(String L3InstID);
}
