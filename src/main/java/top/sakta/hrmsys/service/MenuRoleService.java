package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.MenuRole;

import java.util.List;


public interface MenuRoleService {
    MenuRole getMenuRoleById(Integer id);

    //根据mid和rid查询
    MenuRole getMenuRoleByMidAndRId(Integer menuId, Integer roleId);

    List<MenuRole> getMenuRoleByRId(Integer roleId);

    List<MenuRole> getAllMenuRoles();

    int insertMenuRole(MenuRole menuRole);

    int updateMenuRole(MenuRole menuRole);

    int deleteMenuRole(Integer id);
}
