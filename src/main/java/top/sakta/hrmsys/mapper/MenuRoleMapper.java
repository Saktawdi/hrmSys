package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.MenuRole;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    @Select("SELECT * FROM menu_role WHERE id = #{id}")
    MenuRole getMenuRoleById(Integer id);

    @Select("SELECT * FROM menu_role WHERE rID = #{roleId}")
    MenuRole getMenuRoleByRId(Integer roleId);

    @Select("SELECT * FROM menu_role")
    List<MenuRole> getAllMenuRoles();

    @Insert("INSERT INTO menu_role (mId, rId) VALUES (#{mId}, #{rId})")
    int insertMenuRole(MenuRole menuRole);

    @Update("UPDATE menu_role SET mId=#{mId}, rId=#{rId} WHERE id=#{id}")
    int updateMenuRole(MenuRole menuRole);

    @Delete("DELETE FROM menu_role WHERE id=#{id}")
    int deleteMenuRole(Integer id);

}
