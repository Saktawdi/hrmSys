package top.sakta.hrmsys.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.Role;

import java.util.List;

/**
 * 角色Mapper
 * @author: sakta
 * @version 1.0
 * @data: 2023/12/22
 */

@Mapper
public interface RoleMapper {
    @Select("select * from role where rID = #{rID}")
    Role getRoleByrID(Integer rID);

    @Select("select * from role")
    List<Role> getAllRoles();

    @Insert("INSERT INTO role (rID,rCode,rName) VALUES (#{rID},#{rCode},#{rName})")
    int insertRole(Role role);

    @Update("UPDATE role SET rCode=#{rCode},rName=#{rName} WHERE rID=#{rID}")
    int updateRole(Role role);

    @Update("DELETE FROM role WHERE rID=#{rID}")
    int deleteRole(Integer rID);
}
