package top.sakta.hrmsys.service;

import top.sakta.hrmsys.domain.User;

import java.util.List;

/**
 * userService
 * @author sakta
 * @version 1.0
 * @data 2023年12月22日
 */
public interface UserService {
    User getUserById(String userId);
    List<User> getUserByName(String userName);
    List<User> getAllUsers();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(String userId);
}
