package top.sakta.hrmsys;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sakta.hrmsys.domain.User;
import top.sakta.hrmsys.mapper.UserMapper;
import top.sakta.hrmsys.utils.Md5Util;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    @Autowired
    private UserMapper userMapper;

//    生成md5
//    @Test
//    public void testMD5(){
//        System.out.println(Md5Util.getMD5("www.scf520"));
//    }

    @Test
    public void testGetUserById(){
        System.out.println(userMapper.getUserById("1"));
    }

    @Test
    public void testGetAllUsers(){
        System.out.println(userMapper.getAllUsers());
    }

    @Test
    public void testLogin1(){
        String uID = "1";
        String pwd = "www.scf520";
        User user = userMapper.getUserById(uID);
        if (Md5Util.getMD5(pwd).equals(user.getUPassword())){
            StpUtil.login(user.getUID());
            System.out.println(SaResult.ok("登录成功").setData(StpUtil.getTokenInfo().tokenValue));
        }
    }




}
