package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.MenuRole;

import java.util.List;

@Mapper
public interface MenuRoleMapper {

    @Select("SELECT * FROM menu_role WHERE id = #{id}")
    MenuRole getMenuRoleById(Integer id);

    //根据mid和rid查询
    @Select("SELECT * FROM menu_role WHERE mId = #{menuId} AND rId = #{roleId}")
    MenuRole getMenuRoleByMRId(Integer menuId, Integer roleId);

    @Select("SELECT * FROM menu_role WHERE rID = #{roleId}")
    List<MenuRole> getMenuRoleByRId(Integer roleId);

    @Select("SELECT * FROM menu_role")
    List<MenuRole> getAllMenuRoles();

    @Insert("INSERT INTO menu_role (mId, rId) VALUES (#{mId}, #{rId})")
    int insertMenuRole(MenuRole menuRole);

    @Update("UPDATE menu_role SET mId=#{mId}, rId=#{rId} WHERE id=#{id}")
    int updateMenuRole(MenuRole menuRole);

    @Delete("DELETE FROM menu_role WHERE id=#{id}")
    int deleteMenuRole(Integer id);

}
