package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.sakta.hrmsys.domain.User;
import top.sakta.hrmsys.service.impl.UserServiceImpl;
import top.sakta.hrmsys.utils.Md5Util;

import java.util.List;

/**
 * 用户控制器
 * @author  sakta*
 * @version 0.0.1
 * @date 2023年12月22日*
 */

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "用户接口模块")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Operation(summary = "登录接口",description = "json数据，看用户实体类，uName可无")
    @PostMapping("/login")
    public SaResult login(@RequestBody User user) {
        if(user.getUID() == null || user.getUPassword() == null){
            return SaResult.error("账号/密码不能为空");
        }
        User newUser = userService.getUserById(user.getUID());
        if(newUser == null){
            return SaResult.error("查无此用户");
        }
        if (Md5Util.getMD5(user.getUPassword()).equals(newUser.getUPassword())){
            StpUtil.login(user.getUID());
            return SaResult.ok("登录成功").setData(StpUtil.getTokenInfo().tokenValue);
        }else{
            return SaResult.error("账号/密码错误");
        }
    }

    @SaCheckLogin
    @Operation(summary = "登出接口",description = "无参数")
    @PutMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @SaCheckLogin
    @Operation(summary = "获取当前用户权限",description = "无参数")
    @GetMapping("/getInfo")
    public SaResult getInfo() {
        return SaResult.ok("获取成功").setData(StpUtil.getPermissionList());
    }

    @SaCheckLogin
    @Operation(summary = "获取当前用户角色",description = "无参数")
    @GetMapping("/getRole")
    public SaResult getRole() {
        return SaResult.ok("获取成功").setData(StpUtil.getRoleList());
    }

    @SaCheckPermission("user.add")
    @Operation(summary = "注册接口",description = "json数据，看用户实体类，全属性必须")
    @PostMapping("/register")
    public SaResult register(@RequestBody User user) {
        if(userService.getUserById(user.getUID()) != null){
            return SaResult.error("用户已存在");
        }
        user.setUPassword(Md5Util.getMD5(user.getUPassword()));
        userService.insertUser(user);
        return SaResult.ok("注册成功");
    }

    @SaCheckPermission("user.delete")
    @Operation(summary = "删除用户接口",description = "根据uID删除用户，参数为uID")
    @DeleteMapping("/delete/{id}")
    public SaResult deleteUser(@PathVariable("id") String id) {
        int result = userService.deleteUser(id);
        if(result == 0){
            return SaResult.error("删除失败");
        }
        return SaResult.ok("删除成功");
    }

    @SaCheckPermission("user.update")
    @Operation(summary = "更新用户接口",description = "json数据，看用户实体类，全属性必须")
    @PutMapping("/update")
    public SaResult updateUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setUID(user.getUID());
        newUser.setUName(user.getUName());
        newUser.setUPassword(Md5Util.getMD5(user.getUPassword()));
        int result = userService.updateUser(newUser);
        if(result == 0){
            return SaResult.error("更新失败");
        }
        return SaResult.ok("更新成功");
    }

    @SaCheckPermission("user.all")
    @Operation(summary = "获取所有用户接口",description = "无参数")
    @GetMapping("/getAll")
    public SaResult getAllUser() {
        List<User> userList = userService.getAllUsers();
        return SaResult.ok("获取成功").setData(userList);
    }

    @SaCheckPermission("user.get")
    @Operation(summary = "获取用户接口",description = "根据uID获取用户，参数为uID")
    @GetMapping("/get/{id}")
    public SaResult getUser(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        if(user == null){
            return SaResult.error("查无此用户");
        }
        return SaResult.ok("获取成功").setData(user);
    }

    @SaCheckPermission("user.get")
    @Operation(summary = "获取用户接口",description = "根据uName获取用户，参数为uName")
    @GetMapping("/getByName/{name}")
    public SaResult getUserByName(@PathVariable("name") String name) {
        List<User> userList = userService.getUserByName(name);
        if(userList == null){
            return SaResult.error("查无此用户");
        }
        return SaResult.ok("获取成功").setData(userList);
    }

    @SaCheckRole("admin")
    @Operation(summary = "获取所有登录会话",description = "无参数")
    @GetMapping("/getAllLoginSession")
    public SaResult getAllLoginSession() {
        // 获取所有已登录的会话id
        List<String> sessionIdList = StpUtil.searchSessionId("", 0, -1, false);
        return SaResult.ok("获取成功").setData(sessionIdList);
    }
}
