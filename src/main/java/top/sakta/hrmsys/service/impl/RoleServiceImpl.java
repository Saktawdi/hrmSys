package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Role;
import top.sakta.hrmsys.mapper.RoleMapper;
import top.sakta.hrmsys.service.RoleService;

import java.util.List;

/**
 * roleService实现类
 * @author sakta*
 * @version 1.0
 * @data 2023年12月22日
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleByrID(Integer rID) {
        return roleMapper.getRoleByrID(rID);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public int deleteRole(Integer rID) {
        return roleMapper.deleteRole(rID);
    }
}
