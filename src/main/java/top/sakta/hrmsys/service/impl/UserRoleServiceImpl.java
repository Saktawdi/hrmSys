package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.UserRole;
import top.sakta.hrmsys.mapper.UserRoleMapper;
import top.sakta.hrmsys.service.UserRoleService;

import java.util.List;

/**
 * 用户角色服务实现类
 * @author
 * @version 0.0.1
 * @date 2020/3/14 15:47
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleMapper.getAllUserRoles();
    }

    @Override
    public List<String> getAllUIDByRID(Integer rID) {
        return userRoleMapper.getAllUIDByRID(rID);
    }

    @Override
    public List<Integer> getAllRIDByUID(String uID) {
        return userRoleMapper.getAllRIDByUID(uID);
    }

    @Override
    public int updateUserRole(UserRole userRole) {
        return userRoleMapper.updateUserRole(userRole);
    }

    @Override
    public int insertUserRole(UserRole userRole) {
        return userRoleMapper.insertUserRole(userRole);
    }

    @Override
    public int deleteUserRoleByUID(String uID) {
        return userRoleMapper.deleteUserRoleByUID(uID);
    }

    @Override
    public int deleteUserRoleById(Integer id) {
        return userRoleMapper.deleteUserRoleById(id);
    }
}
