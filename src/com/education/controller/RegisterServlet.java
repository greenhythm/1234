package com.education.controller;

import com.education.service.UserService;
import com.education.service.impl.UserServiceImpl;
import com.education.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册Servlet (User Registration Controller)
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        String studentName = request.getParameter("studentName");
        String studentId = request.getParameter("studentId");
        String major = request.getParameter("major");

        // 参数验证
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            studentName == null || studentName.trim().isEmpty() ||
            studentId == null || studentId.trim().isEmpty()) {
            response.sendRedirect("register?error=参数不能为空");
            return;
        }

        // 检查密码是否一致
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register?error=两次密码不一致");
            return;
        }

        // 检查密码长度
        if (password.length() < 6) {
            response.sendRedirect("register?error=密码长度不能少于6位");
            return;
        }

        // 检查用户名是否存在
        if (userService.checkUsernameExists(username)) {
            response.sendRedirect("register?error=用户名已存在");
            return;
        }

        // 检查邮箱是否存在
        if (userService.checkEmailExists(email)) {
            response.sendRedirect("register?error=邮箱已被注册");
            return;
        }

        // 检查学号是否存在
        if (userService.checkStudentIdExists(studentId)) {
            response.sendRedirect("register?error=学号已被注册");
            return;
        }

        // 创建新用户对象
        User user = new User(username, password, email, studentName, studentId);
        user.setMajor(major);

        // 执行注册
        if (userService.register(user)) {
            response.sendRedirect("login?success=注册成功，请登录");
        } else {
            response.sendRedirect("register?error=注册失败，请稍后重试");
        }
    }
}
