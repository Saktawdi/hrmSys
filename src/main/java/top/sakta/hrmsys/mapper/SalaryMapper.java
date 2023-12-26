package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Salary;

import java.util.Date;
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

    @Insert("INSERT INTO salary (sID,sName,sBasic,sTransport,sLunch,sCommunicate,sPension,sMedical,sUnemployment,sHouse,sRecorder,sRecordDate,sMaker,sChecker,sStatus,sOpinion) VALUES (#{sID},#{sName},#{sBasic},#{sTransport},#{sLunch},#{sCommunicate},#{sPension},#{sMedical},#{sUnemployment},#{sHouse},#{sRecorder},#{sRecordDate},#{sMaker},#{sChecker},#{sStatus},#{sOpinion})")
    int insertSalary(Salary salary);

    @Update("UPDATE salary SET sName=#{sName},sBasic=#{sBasic},sTransport=#{sTransport},sLunch=#{sLunch},sCommunicate=#{sCommunicate},sPension=#{sPension},sMedical=#{sMedical},sUnemployment=#{sUnemployment},#{sHouse},sRecorder=#{sRecorder},sRecordDate=#{sRecordDate},sMaker=#{sMaker},sChecker=#{sChecker},sStatus=#{sStatus},sOpinion=#{sOpinion} WHERE sID=#{sID}")
    int updateSalary(Salary salary);

    @Delete("DELETE FROM salary WHERE sID=#{sID}")
    int deleteSalary(Integer sID);

    @Select("SELECT * FROM salary WHERE sStatus = #{sStatus}")
    List<Salary> getSalaryByStatus(int sStatus);

    @Update("UPDATE salary SET sStatus=#{sStatus},sChecker=#{uID} WHERE sID = #{sID}")
    int updateSalaryStatus(Integer sID,int sStatus,String uID);

    @Select("<script>" +
            "SELECT * FROM salary <where> "  +
            "<if test =\"sID != null\"> AND sID LIKE '%${sID}%'</if>" +
            "<if test =\"keyWords != null and keyWords != ''\"> AND sName LIKE '%${keyWords}%' </if>" +
            "<if test =\"uID != null and uID != ''\"> AND (sRecorder = #{uID} OR sMaker = #{uID} OR sChecker = #{uID}) </if>" +
            "<if test =\"StartRecodDate != null and EndRecodDate != null\"> AND sRecordDate BETWEEN #{StartRecodDate} AND #{EndRecodDate} </if>" +
            " </where></script>")
    List<Salary> getSalariesByConditions(Integer sID, String keyWords, String uID, Date StartRecodDate, Date EndRecodDate);

}
