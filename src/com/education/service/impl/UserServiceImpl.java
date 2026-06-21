package com.education.service.impl;

import com.education.service.UserService;
import com.education.dao.UserDAO;
import com.education.dao.impl.UserDAOImpl;
import com.education.model.User;

/**
 * 用户业务逻辑实现类 (User Service Implementation)
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean register(User user) {
        // 检查用户名是否已存在
        if (userDAO.isUsernameExists(user.getUsername())) {
            return false;
        }
        // 检查邮箱是否已存在
        if (userDAO.isEmailExists(user.getEmail())) {
            return false;
        }
        // 检查学号是否已存在
        if (userDAO.isStudentIdExists(user.getStudentId())) {
            return false;
        }
        // 执行注册
        return userDAO.register(user);
    }

    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDAO.getUserById(userId);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return userDAO.isUsernameExists(username);
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userDAO.isEmailExists(email);
    }

    @Override
    public boolean checkStudentIdExists(String studentId) {
        return userDAO.isStudentIdExists(studentId);
    }

    @Override
    public boolean updateUserInfo(User user) {
        return userDAO.updateUser(user);
    }
}
