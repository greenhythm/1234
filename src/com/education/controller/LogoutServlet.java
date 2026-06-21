package com.education.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登出Servlet (User Logout Controller)
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取Session
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 清除Session
            session.removeAttribute("user");
            session.removeAttribute("userId");
            session.invalidate();
        }
        // 重定向到登录页面
        response.sendRedirect("login");
    }
}
