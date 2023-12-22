package top.sakta.hrmsys.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.UserRole;

import java.util.List;

/**
 * userroleMapper
 * @author sakta
 * @version 1.0
 * @data 2023年12月22日
 */

@Mapper
public interface UserRoleMapper {
    //找到所有的用户角色
    @Select("select * from user_role")
    List<UserRole> getAllUserRoles();

    //找到对应角色ID下的所有用户ID
    @Select("select uID from user_role where rID = #{rID}")
    List<String> getAllUIDByRID(Integer rID);

    //找到对应用户ID下的所有角色ID
    @Select("select rID from user_role where uID = #{uID}")
    List<Integer> getAllRIDByUID(String uID);

    //修改
    @Update("UPDATE user_role SET rID=#{rID} WHERE uID=#{uID}")
    int updateUserRole(UserRole userRole);

    //增加
    @Insert("INSERT INTO user_role(uID,rID) VALUES(#{uID},#{rID})")
    int insertUserRole(UserRole userRole);

    //删除用户对应角色
    @Update("DELETE FROM user_role WHERE uID=#{uID}")
    int deleteUserRoleByUID(String uID);

    //根据行id删除行记录
    @Update("DELETE FROM user_role WHERE id=#{id}")
    int deleteUserRoleById(Integer id);
}
