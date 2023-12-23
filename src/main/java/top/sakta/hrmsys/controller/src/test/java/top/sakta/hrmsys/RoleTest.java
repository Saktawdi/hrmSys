package top.sakta.hrmsys;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sakta.hrmsys.domain.Role;
import top.sakta.hrmsys.mapper.RoleMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testGetRoleByrID(){
        System.out.println(roleMapper.getRoleByrID(1));
    }

    @Test
    public void testGetAllRoles(){
        System.out.println(roleMapper.getAllRoles());
    }

    @Test
    public void testInsertRole(){
        try {
            Role role = new Role();
            role.setRID(3);
            role.setRCode("test");
            role.setRName("测试人员");
            int result = roleMapper.insertRole(role);
            System.out.println(result);
        } catch (Exception e) {
            if (e.getCause().toString().contains("Duplicate entry")){
                System.out.println("重复id");
            } else {
                e.printStackTrace(); // 打印其他异常的堆栈信息
            }
        }
    }



}
