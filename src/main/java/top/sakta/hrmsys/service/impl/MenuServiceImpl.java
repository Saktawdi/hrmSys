package top.sakta.hrmsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sakta.hrmsys.domain.Menu;
import top.sakta.hrmsys.mapper.MenuMapper;
import top.sakta.hrmsys.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu getMenuById(Integer id) {
        return menuMapper.getMenuById(id);
    }



    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Override
    public int insertMenu(Menu menu) {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int deleteMenu(Integer id) {
        return menuMapper.deleteMenu(id);
    }
}
