package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.MenuRole;
import top.sakta.hrmsys.mapper.MenuRoleMapper;
import top.sakta.hrmsys.service.MenuRoleService;

import java.util.List;

@Service
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public MenuRole getMenuRoleById(Integer id) {
        return menuRoleMapper.getMenuRoleById(id);
    }

    @Override
    public MenuRole getMenuRoleByMidAndRId(Integer menuId, Integer roleId) {
        return menuRoleMapper.getMenuRoleByMRId(menuId, roleId);
    }

    @Override
    public List<MenuRole> getMenuRoleByRId(Integer roleId) {
        return menuRoleMapper.getMenuRoleByRId(roleId);
    }

    @Override
    public List<MenuRole> getAllMenuRoles() {
        return menuRoleMapper.getAllMenuRoles();
    }

    @Override
    public int insertMenuRole(MenuRole menuRole) {
        return menuRoleMapper.insertMenuRole(menuRole);
    }

    @Override
    public int updateMenuRole(MenuRole menuRole) {
        return menuRoleMapper.updateMenuRole(menuRole);
    }

    @Override
    public int deleteMenuRole(Integer id) {
        return menuRoleMapper.deleteMenuRole(id);
    }
}
