package com.education.dao;

import com.education.model.User;
import java.util.List;

/**
 * 用户数据访问接口 (User DAO Interface)
 */
public interface UserDAO {
    /**
     * 用户注册
     */
    boolean register(User user);

    /**
     * 用户登录
     */
    User login(String username, String password);

    /**
     * 根据ID查询用户
     */
    User getUserById(Integer userId);

    /**
     * 根据用户名查询用户
     */
    User getUserByUsername(String username);

    /**
     * 检查用户名是否存在
     */
    boolean isUsernameExists(String username);

    /**
     * 检查邮箱是否存在
     */
    boolean isEmailExists(String email);

    /**
     * 检查学号是否存在
     */
    boolean isStudentIdExists(String studentId);

    /**
     * 查询所有用户
     */
    List<User> getAllUsers();

    /**
     * 更新用户信息
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     */
    boolean deleteUser(Integer userId);
}
