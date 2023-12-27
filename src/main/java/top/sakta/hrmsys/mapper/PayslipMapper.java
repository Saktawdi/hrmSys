package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.sakta.hrmsys.domain.Payslip;

import java.util.List;

@Mapper
public interface PayslipMapper {
    @Select("SELECT bonus.eID eID,eName,sBasic,sTransport,sLunch,sCommunicate,sPension,sMedical,sUnemployment,sHouse,bReward,bReduce FROM employee,salary,bonus where eSalary = sID AND bonus.eID = employee.eID AND eStatus = 1 AND sStatus = 1 AND eL3InstID = #{L3InstID}")
    List<Payslip> getPayslipsByL3InstID(String L3InstID);


}
