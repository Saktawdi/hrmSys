package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Payslip;
import top.sakta.hrmsys.mapper.PayslipMapper;
import top.sakta.hrmsys.service.PayslipService;

import java.util.List;

@Service
public class PayslipServiceImpl implements PayslipService {
    @Autowired
    private PayslipMapper payslipMapper;

    @Override
    public List<Payslip> getPayslipsByL3InstID(String L3InstID) {
        return payslipMapper.getPayslipsByL3InstID(L3InstID);
    }
}
