package top.sakta.hrmsys.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.sakta.hrmsys.domain.MenuRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义权限加载接口实现类
 * @author sakta
 * @version 0.0.1*
 * @date 2023年12月22日*
 */
//TODO:Test
@Component    // 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
@Log
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private MenuServiceImpl menuService;

    @Autowired
    private MenuRoleServiceImpl menuRoleService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<Integer> rIdsList = userRoleService.getAllRIDByUID(String.valueOf(loginId));
        Set<Integer> rIdsSet = new HashSet<>(rIdsList);
        List<String> menuCode = new ArrayList<String>();
        for (Integer rId : rIdsSet) {
            // MenuRole行ID
            try {
                MenuRole menuRole = menuRoleService.getMenuRoleByRId(rId);
                if (menuRole != null) {
                    Integer mid = menuRole.getMId();
                    if (mid != null) {
                        menuCode.add(menuService.getMenuById(mid).getMCode());
                    } else {
                        log.info("MenuRole行ID为空");
                    }
                } else {
                    log.info("MenuRole为空");
                }
            } catch (NullPointerException e) {
                log.warning("出现空指针异常");
            }
        }
        return menuCode;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Integer> rIdsList = userRoleService.getAllRIDByUID(String.valueOf(loginId));
        Set<Integer> rIdsSet = new HashSet<>(rIdsList);
       List<String> rCodes = new ArrayList<String>();
       for (Integer rId : rIdsSet) {
           rCodes.add(roleService.getRoleByrID(rId).getRCode());
       }
       return rCodes;
    }
}
