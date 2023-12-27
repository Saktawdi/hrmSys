package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.Payroll;

import java.util.List;

/**
 * Mapper 新凑发放单Mapper
 * @author Quescc
 * @version 1.0
 * @data 2023年12月27日
 */

@Mapper
public interface PayrollMapper {
    @Select("SELECT eL3InstID pL3InstID,(SELECT iName FROM institution WHERE iID = eL1InstID) pL1InstName,(SELECT iName FROM institution WHERE iID = eL2InstID) pL2InstName,iName pL3InstName,count(eID) pCount,SUM(sBasic) pSalarySum FROM employee,salary,institution WHERE eL3InstID = iID AND eSalary = sID AND eStatus = 1 GROUP BY eL3InstID;")
    List<Payroll> getAllPayrolls();

    @Update("INSERT INTO payroll (pID,pL3InstID,pL1InstName,pL2InstName,pL3InstName,pCount,pSalarySum,pStatus,pMaker,pPayslips) VALUES (#{pID},#{pL3InstID},#{pL1InstName},#{pL2InstName},#{pL3InstName},#{pCount},#{pSalarySum},#{pStatus},#{pMaker},#{pPayslips})")
    int insertPayroll(Payroll payroll);

    @Select("SELECT * FROM payroll")
    List<Payroll> getAll();

    @Select("SELECT * FROM payroll WHERE pStatus = #{pStatus}")
    List<Payroll> getPayrollsByStatus(int pStatus);

    @Update("UPDATE payroll SET pStatus = #{pStatus} WHERE pID = #{pID}")
    int updatePayrollStatus(int pID,int pStatus);

    @Delete("DELETE FROM payroll WHERE pID = #{pID}")
    int deletePayroll(int pID);
}
