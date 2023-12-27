package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.sakta.hrmsys.domain.Payroll;

import java.util.List;

@Mapper
public interface PayrollMapper {
    @Select("SELECT (SELECT iName FROM institution WHERE iID = eL1InstID) eL1InstName,(SELECT iName FROM institution WHERE iID = eL2InstID) eL2InstName,iName eL3InstName,count(eID) count,SUM(sBasic) salarySum FROM employee,salary,institution WHERE eL3InstID = iID AND eSalary = sID GROUP BY eL3InstID;")
    List<Payroll> getAllPayrolls();
}
