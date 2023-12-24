package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.Institution;

import java.util.List;

/**
 * Mapper 机构Mapper
 * @author Quescc
 * @version 1.0
 * @data 2023年12月23日
 */

@Mapper
public interface InstitutionMapper {
    @Select("SELECT * FROM institution WHERE iID = #{iID}")
    Institution getInstitutionByID(String iID);

    @Select("SELECT * FROM institution")
    List<Institution> getAllInstitutions();

    @Insert("INSERT INTO institution (iID,iName,iLevel,iParent) VALUES (#{iID},#{iName},#{iLevel},#{iParent})")
    int insertInstitution(Institution institution);

    @Update("UPDATE institution SET iName=#{iName},iLevel=#{iLevel},iParent=#{iParent} WHERE iID=#{iID}")
    int updateInstitution(Institution institution);

    @Delete("DELETE FROM institution WHERE iID=#{iID}")
    int deleteInstitution(String rID);

    @Select("SELECT * FROM institution WHERE iLevel = #{iLevel}")
    List<Institution> getInstitutionByLevel(Integer iLevel);

    @Select("SELECT * FROM institution WHERE iLevel = #{iLevel} AND iParent = #{iParent}")
    List<Institution> getInstitutionByLevelAndParent(Integer iLevel,String iParent);

    @Select("SELECT * FROM institution WHERE iParent = #{iParent}")
    List<Institution> getInstitutionsByParent(String iParent);

}
