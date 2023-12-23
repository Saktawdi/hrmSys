package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.Menu;

import java.util.List;

public interface MenuService {

    Menu getMenuById(Integer id);

    List<Menu> getAllMenus();

    int insertMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenu(Integer id);
}
