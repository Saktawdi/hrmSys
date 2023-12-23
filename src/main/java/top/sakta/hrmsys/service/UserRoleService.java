package top.sakta.hrmsys.service;
import top.sakta.hrmsys.domain.UserRole;

import java.util.List;

/**
 * @author sakta
 * @version 0.0.1*
 * @date 2023年12月22日
 */

public interface UserRoleService {

    //找到所有的用户角色
    List<UserRole> getAllUserRoles();

    //找到对应uID和rID的用户角色
    UserRole getUserRoleByUIDAndRID(String uID, Integer rID);

    //找到对应角色ID下的所有用户ID
    List<String> getAllUIDByRID(Integer rID);

    //找到对应用户ID下的所有角色ID
    List<Integer> getAllRIDByUID(String uID);

    //修改
    int updateUserRole(UserRole userRole);

    //增加
    int insertUserRole(UserRole userRole);

    //删除用户对应角色
    int deleteUserRoleByUID(String uID);

    //根据行id删除行记录
    int deleteUserRoleById(Integer id);
}
