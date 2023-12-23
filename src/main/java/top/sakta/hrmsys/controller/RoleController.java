package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.Role;
import top.sakta.hrmsys.service.impl.RoleServiceImpl;
import top.sakta.hrmsys.service.impl.UserRoleServiceImpl;

import java.util.List;

/**
 * 用户角色控制器
 * @author sakta*
 * @version 0.0.1
 * @date 2023年12月22日*
 */

@Tag(name = "角色接口模块")
@RestController
@RequestMapping ("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @SaCheckPermission("role.all")
    @Operation(summary = "获取所有角色",description = "无参数")
    @GetMapping("/all")
    public SaResult getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return SaResult.ok().setData(roles);
    }

    @SaCheckPermission("role.add")
    @Operation(summary = "添加角色",description = "json数据，看角色实体类，全属性必须")
    @PostMapping("/add")
    public SaResult addRole(@RequestBody Role role){
        int result = roleService.insertRole(role);
        if (result == 0){
            return SaResult.error("添加失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("role.update")
    @Operation(summary = "更新角色",description = "json数据，看角色实体类，全属性必须")
    @PutMapping("/update")
    public SaResult updateRole(@RequestBody Role role){
        int result = roleService.updateRole(role);
        if (result == 0){
            return SaResult.error("更新失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("role.delete")
    @Operation(summary = "删除角色",description = "根据rID删除角色")
    @DeleteMapping ("/delete/{rID}")
    public SaResult deleteRole(@PathVariable Integer rID){
        int result = roleService.deleteRole(rID);
        if (result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok();
    }

    @SaCheckPermission("role.get")
    @Operation(summary = "获取角色",description = "根据rID获取角色")
    @GetMapping("/get/{rID}")
    public SaResult getRole(@PathVariable Integer rID){
        Role role = roleService.getRoleByrID(rID);
        if (role == null){
            return SaResult.error("查无此角色");
        }
        return SaResult.ok().setData(role);
    }
}
