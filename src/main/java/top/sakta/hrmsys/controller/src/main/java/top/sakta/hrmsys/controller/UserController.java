package top.sakta.hrmsys.controller;


import cn.dev33.satoken.annotation.SaCheckPermission;
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

    @Operation(summary = "登出接口",description = "无参数")
    @PutMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
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

}
