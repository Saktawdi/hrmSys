package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Salary;

import java.util.List;

/**
 * Mapper 薪资标准Mapper
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

@Mapper
public interface SalaryMapper {
    @Select("SELECT * FROM salary WHERE sID = #{sID}")
    Salary getSalaryByID(Integer sID);

    @Select("SELECT * FROM salary")
    List<Salary> getAllSalaries();

    @Insert("INSERT INTO salary (sID,sName,sBasic,sTransport,sLunch,sCommunicate,sPension,sMedical,sUnemployment,sRecorder,sRecordDate,sMaker,sStatus) VALUES (#{sID},#{sName},#{sBasic},#{sTransport},#{sLunch},#{sCommunicate},#{sPension},#{sMedical},#{sUnemployment},#{sRecorder},#{sRecordDate},#{sMaker},#{sStatus})")
    int insertSalary(Salary salary);

    @Update("UPDATE salary SET sName=#{sName},sBasic=#{sBasic},sTransport=#{sTransport},sLunch=#{sLunch},sCommunicate=#{sCommunicate},sPension=#{sPension},sMedical=#{sMedical},sUnemployment=#{sUnemployment},sRecorder=#{sRecorder},sRecordDate=#{sRecordDate},sMaker=#{sMaker},sStatus=#{sStatus} WHERE sID=#{sID}")
    int updateSalary(Salary salary);

    @Delete("DELETE FROM salary WHERE sID=#{sID}")
    int deleteSalary(Integer sID);
}
