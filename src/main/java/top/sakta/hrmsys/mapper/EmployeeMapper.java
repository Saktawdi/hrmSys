package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Employee;

import java.util.Date;
import java.util.List;

/**
 * Mapper 档案Mapper
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE eID = #{eID}")
    Employee getEmployeeByID(String eID);

    @Select("SELECT * FROM employee")
    List<Employee> getAllEmployees();

    @Insert("INSERT INTO employee (eID,eL1InstID,eL2InstID,eL3InstID,ePositionCategory,ePositionName,eJobTitle,eName,eGender,eAge,eEmail,eFixedPhone,eCellPhone,eQQ,eAddress,ePostcode,eBirthday,eBirthplace,eAvatar,eIDcard,eSSC,eCountry,eEthnic,eReligion,ePolitical,eEducation,eMajor,eSalary,eBankName,eBankAccount,eHobby,eSpecicalty,eResume,eFamily,eRemarks,eRecoders,eRecodDate,eStatus) VALUES (#{eID},#{eL1InstID},#{eL2InstID},#{eL3InstID},#{ePositionCategory},#{ePositionName},#{eJobTitle},#{eName},#{eGender},#{eAge},#{eEmail},#{eFixedPhone},#{eCellPhone},#{eQQ},#{eAddress},#{ePostcode},#{eBirthday},#{eBirthplace},#{eAvatar},#{eIDcard},#{eSSC},#{eCountry},#{eEthnic},#{eReligion},#{ePolitical},#{eEducation},#{eMajor},#{eSalary},#{eBankName},#{eBankAccount},#{eHobby},#{eSpecicalty},#{eResume},#{eFamily},#{eRemarks},#{eRecoders},#{eRecodDate},#{eStatus})")
    int insertEmployee(Employee employee);

    @Update("UPDATE employee SET eL1InstID=#{eL1InstID},eL2InstID=#{eL2InstID},eL3InstID=#{eL3InstID},ePositionCategory=#{ePositionCategory},ePositionName=#{ePositionName},eJobTitle=#{eJobTitle},eName=#{eName},eGender=#{eGender},eAge=#{eAge},eEmail=#{eEmail},eFixedPhone=#{eFixedPhone},eCellPhone=#{eCellPhone},eQQ=#{eQQ},eAddress=#{eAddress},ePostcode=#{ePostcode},eBirthday=#{eBirthday},eBirthplace=#{eBirthplace},eAvatar=#{eAvatar},eIDcard=#{eIDcard},eSSC=#{eSSC},eCountry=#{eCountry},eEthnic=#{eEthnic},eReligion=#{eReligion},ePolitical=#{ePolitical},eEducation=#{eEducation},eMajor=#{eMajor},eSalary=#{eSalary},eBankName=#{eBankName},eBankAccount=#{eBankAccount},eHobby=#{eHobby},eSpecicalty=#{eSpecicalty},eResume=#{eResume},eFamily=#{eFamily},eRemarks=#{eRemarks},eRecoders=#{eRecoders},eRecodDate=#{eRecodDate},eStatus=#{eStatus} WHERE eID=#{eID}")
    int updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE eID=#{eID}")
    int deleteEmployee(String eID);

    @Select("SELECT * FROM employee WHERE eID LIKE '${ID}%'")
    List<Employee> getEmployeeLikeID(String ID);

    @Select("SELECT * FROM employee WHERE eStatus = #{eStatus}")
    List<Employee> getEmployeesByStatus(int eStatus);

    @Select("<script> " +
            "SELECT * FROM employee <where> " +
            "<if test =\"eL1InstID != null and eL1InstID != ''\"> AND eL1InstID = #{eL1InstID}</if>" +
            "<if test =\"eL2InstID != null and eL2InstID != ''\"> AND eL2InstID = #{eL2InstID}</if>" +
            "<if test =\"eL3InstID != null and eL3InstID != ''\"> AND eL3InstID = #{eL3InstID}</if>" +
            "<if test =\"ePositionCategory != null and ePositionCategory != ''\"> AND ePositionCategory = #{ePositionCategory}</if>" +
            "<if test =\"ePositionName != null and ePositionName != ''\"> AND ePositionName = #{ePositionName}</if>" +
            "<if test =\"StartRecodDate != null and EndRecodDate != null\"> AND eRecodDate BETWEEN #{StartRecodDate} AND #{EndRecodDate}</if>" +
            " </where></script>")
    List<Employee> getEmployeesByConditions(String eL1InstID, String eL2InstID, String eL3InstID, String ePositionCategory, String ePositionName, Date StartRecodDate, Date EndRecodDate);

    @Update("UPDATE employee SET eStatus=#{eStatus} WHERE eID=#{eID}")
    int updateEmployeeStatus(String eID,int eStatus);
}
