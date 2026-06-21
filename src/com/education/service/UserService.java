package com.education.service;

import com.education.model.User;
import java.util.List;

/**
 * 用户业务逻辑接口 (User Service Interface)
 */
public interface UserService {
    /**
     * 用户注册
     */
    boolean register(User user);

    /**
     * 用户登录
     */
    User login(String username, String password);

    /**
     * 获取用户信息
     */
    User getUserById(Integer userId);

    /**
     * 检查用户名是否存在
     */
    boolean checkUsernameExists(String username);

    /**
     * 检查邮箱是否存在
     */
    boolean checkEmailExists(String email);

    /**
     * 检查学号是否存在
     */
    boolean checkStudentIdExists(String studentId);

    /**
     * 更新用户信息
     */
    boolean updateUserInfo(User user);
}
