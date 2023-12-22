package top.sakta.hrmsys.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.Role;

import java.util.List;

/**
 * roleService
 * @author sakta
 * @version 1.0
 * @data 2023年12月22日
 */
public interface RoleService {
    Role getRoleByrID(Integer rID);

    List<Role> getAllRoles();

    int insertRole(Role role);

    int updateRole(Role role);

    int deleteRole(Integer rID);
}
