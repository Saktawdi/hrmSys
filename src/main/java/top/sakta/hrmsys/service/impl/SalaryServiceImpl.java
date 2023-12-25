package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Salary;
import top.sakta.hrmsys.mapper.SalaryMapper;
import top.sakta.hrmsys.service.SalaryService;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public Salary getSalaryByID(Integer sID) {
        return salaryMapper.getSalaryByID(sID);
    }

    @Override
    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    @Override
    public int insertSalary(Salary salary) {
        return salaryMapper.insertSalary(salary);
    }

    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    @Override
    public int deleteSalary(Integer sID) {
        return salaryMapper.deleteSalary(sID);
    }

    @Override
    public List<Salary> getSalaryByStatus(String sStatus) {
        return salaryMapper.getSalaryByStatus(sStatus);
    }
}
