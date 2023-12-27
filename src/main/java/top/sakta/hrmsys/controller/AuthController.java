package top.sakta.hrmsys.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.MenuRole;
import top.sakta.hrmsys.domain.User;
import top.sakta.hrmsys.domain.UserRole;
import top.sakta.hrmsys.service.impl.MenuRoleServiceImpl;
import top.sakta.hrmsys.service.impl.RoleServiceImpl;
import top.sakta.hrmsys.service.impl.UserRoleServiceImpl;
import top.sakta.hrmsys.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限控制器
 * @version 0.0.1
 * @date 2023年12月23日
 */
@Tag(name = "权限接口模块",description = "角色分配，权限分配")
@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MenuRoleServiceImpl menuRoleService;

    @SaCheckPermission("auth.get")
    @Operation(summary = "获取角色分配到的所有用户",description = "参数rID")
    @GetMapping("role/all/{rID}")
    public SaResult getAllRoles(@PathVariable Integer rID) {
        List<String> uIDs = userRoleService.getAllUIDByRID(rID);
        List<User> users = new ArrayList<User>();
        for (String uID : uIDs) {
            users.add(userService.getUserById(uID));
        }
        return SaResult.ok().setData(users);
    }

    @SaCheckPermission("auth.add")
    @Operation(summary = "给用户分配角色",description = "参数uID,rID")
    @PostMapping("role/add/{rID}/{uID}")
    public SaResult addRole(@PathVariable Integer rID,@PathVariable String uID){
        User user =  userService.getUserById(uID);
        if (user == null){
            return SaResult.error("用户不存在");
        }
        UserRole userRole = userRoleService.getUserRoleByUIDAndRID(uID,rID);
        if (userRole == null){
            userRole = new UserRole();
            userRole.setUID(uID);
            userRole.setRID(rID);
        }else{
            return SaResult.error("数据已存在");
        }
        int result = userRoleService.insertUserRole(userRole);
        if (result == 0){
            return SaResult.error("添加失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.delete")
    @Operation(summary = "删除用户角色",description = "参数uID,rID")
    @DeleteMapping ("role/delete/{rID}/{uID}")
    public SaResult deleteRole(@PathVariable Integer rID,@PathVariable String uID){
        UserRole userRole = userRoleService.getUserRoleByUIDAndRID(uID,rID);
        if (userRole == null){
            return SaResult.error("数据不存在");
        }
        int result = userRoleService.deleteUserRoleById(userRole.getId());
        if (result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.update")
    @Operation(summary = "修改用户角色",description = "json数据，参数uID,rID必须")
    @PutMapping ("role/update")
    public SaResult updateRole(@RequestBody UserRole userRole){
        int result = userRoleService.updateUserRole(userRole);
        if (result == 0){
            return SaResult.error("修改失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.menu.get")
    @Operation(summary = "获取角色分配到的所有菜单",description = "参数rID")
    @GetMapping("/menu/all/{rID}")
    public SaResult getAllMenus(@PathVariable Integer rID) {
        return SaResult.ok().setData(menuRoleService.getMenuRoleByRId(rID));
    }

    @SaCheckPermission("auth.menu.add")
    @Operation(summary = "给角色分配菜单",description = "参数rID,mID")
    @PostMapping("/menu/add/{rID}/{mID}")
    public SaResult addMenu(@PathVariable Integer rID,@PathVariable Integer mID){
        MenuRole menuRole = menuRoleService.getMenuRoleByMidAndRId(mID,rID);
        if (menuRole == null){
            menuRole = new MenuRole();
            menuRole.setMId(mID);
            menuRole.setRId(rID);
        }else{
            return SaResult.error("数据已存在");
        }
        int result = menuRoleService.insertMenuRole(menuRole);
        if (result == 0){
            return SaResult.error("添加失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.menu.delete")
    @Operation(summary = "删除角色菜单",description = "参数行id")
    @DeleteMapping("/menu/delete/{id}")
    public SaResult deleteMenu(@PathVariable Integer id){
        int result = menuRoleService.deleteMenuRole(id);
        if (result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.menu.delete")
    @Operation(summary = "删除用户菜单",description = "参数rID,mID")
    @DeleteMapping ("/menu/delete/{rID}/{mID}")
    public SaResult deleteMenu(@PathVariable Integer rID,@PathVariable Integer mID){
        MenuRole menuRole = menuRoleService.getMenuRoleByMidAndRId(mID,rID);
        if (menuRole == null){
            return SaResult.error("数据不存在");
        }
        int result = menuRoleService.deleteMenuRole(menuRole.getId());
        if (result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("auth.menu.update")
    @Operation(summary = "修改角色菜单",description = "json数据，参数rid,mid必须")
    @PutMapping("/menu/update")
    public SaResult updateMenu(@RequestBody MenuRole menuRole){
        int result = menuRoleService.updateMenuRole(menuRole);
        if (result == 0){
            return SaResult.error("修改失败");
        }
        return SaResult.ok();
    }

}
