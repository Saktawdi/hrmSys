package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Menu;
import top.sakta.hrmsys.service.impl.MenuServiceImpl;

/**
 * 菜单控制器
 * @author sakta*
 * @version 0.0.1
 * @data 2023年12月23日
 */

@Tag(name = "菜单接口模块")
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;

    @SaCheckPermission("menu.all")
    @Operation(summary = "获取所有菜单",description = "无参数")
    @GetMapping ("/all")
    public SaResult getAllMenus(){
        return SaResult.ok().setData(menuService.getAllMenus());
    }

    @SaCheckPermission("menu.add")
    @Operation(summary = "添加菜单",description = "json数据，看菜单实体类，全属性必须")
    @PostMapping("/add")
    public SaResult addMenu(@RequestBody Menu menu){
        int result = menuService.insertMenu(menu);
        if (result == 0){
            return SaResult.error("添加失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("menu.update")
    @Operation(summary = "更新菜单",description = "json数据，看菜单实体类，全属性必须")
    @PutMapping ("/update")
    public SaResult updateMenu(@RequestBody Menu menu){
        int result = menuService.updateMenu(menu);
        if (result == 0){
            return SaResult.error("更新失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("menu.delete")
    @Operation(summary = "删除菜单",description = "id")
    @DeleteMapping ("/delete/{id}")
    public SaResult deleteMenu(@PathVariable Integer id){
        int result = menuService.deleteMenu(id);
        if (result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("menu.get")
    @Operation(summary = "获取菜单",description = "id")
    @GetMapping ("/get/{id}")
    public SaResult getMenu(@PathVariable Integer id){
        Menu menu = menuService.getMenuById(id);
        if (menu == null){
            return SaResult.error("获取失败");
        }
        return SaResult.ok().setData(menu);
    }

}
