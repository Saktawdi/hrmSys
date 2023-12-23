package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Salary;

import java.util.List;

/**
 * Mapper 薪资标准Service
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

public interface SalaryService {
    Salary getSalaryByID(Integer sID);

    List<Salary> getAllSalaries();

    int insertSalary(Salary salary);

    int updateSalary(Salary salary);

    int deleteSalary(Integer sID);
}
