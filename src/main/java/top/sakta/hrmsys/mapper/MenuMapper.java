package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.*;
import top.sakta.hrmsys.domain.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("SELECT * FROM menu WHERE id = #{id}")
    Menu getMenuById(Integer id);


    @Select("SELECT * FROM menu")
    List<Menu> getAllMenus();

    @Insert("INSERT INTO menu (parentId, mCode, mName, sort) VALUES (#{parentId}, #{mCode}, #{mName}, #{sort})")
    int insertMenu(Menu menu);

    @Update("UPDATE menu SET parentId=#{parentId}, mCode=#{mCode}, mName=#{mName}, sort=#{sort} WHERE id=#{id}")
    int updateMenu(Menu menu);

    @Delete("DELETE FROM menu WHERE id=#{id}")
    int deleteMenu(Integer id);

}
