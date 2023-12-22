package top.sakta.hrmsys.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.sakta.hrmsys.domain.User;

import java.util.List;

/**
 * 用户Mapper
 * @author sakta
 * @version 1.0
 * @date 2023/12/22
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE uID = #{userId}")
    User getUserById(String userId);

    @Select("SELECT * FROM user WHERE uName LIKE '%${userName}%'")
    List<User> getUserByName(String userName);

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert("INSERT INTO user (uID,uName,uPassword) VALUES (#{uID},#{uName},#{uPassword})")
    int insertUser(User user);

    @Update("UPDATE user SET uName=#{uName},uPassword=#{uPassword} WHERE uID=#{uID}")
    int updateUser(User user);

    @Update("DELETE FROM user WHERE uID=#{uID}")
    int deleteUser(String userId);
}
