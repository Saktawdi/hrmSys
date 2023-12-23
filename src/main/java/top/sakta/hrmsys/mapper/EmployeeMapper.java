package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Employee;

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
}
