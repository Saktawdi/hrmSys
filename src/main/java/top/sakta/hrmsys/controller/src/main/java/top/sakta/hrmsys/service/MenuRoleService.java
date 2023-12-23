package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.MenuRole;

import java.util.List;


public interface MenuRoleService {
    MenuRole getMenuRoleById(Integer id);

    MenuRole getMenuRoleByRId(Integer roleId);

    List<MenuRole> getAllMenuRoles();

    int insertMenuRole(MenuRole menuRole);

    int updateMenuRole(MenuRole menuRole);

    int deleteMenuRole(Integer id);
}
