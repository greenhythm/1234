package com.education.controller;

import com.education.service.EnrollmentService;
import com.education.service.impl.EnrollmentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 选课Servlet (Course Enrollment Controller)
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentService enrollmentService = new EnrollmentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        // 检查登录状态
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            response.getWriter().write("{\"success\":false,\"message\":\"请先登录\"}");
            return;
        }

        String courseIdStr = request.getParameter("courseId");
        if (courseIdStr == null || courseIdStr.trim().isEmpty()) {
            response.getWriter().write("{\"success\":false,\"message\":\"课程ID不能为空\"}");
            return;
        }

        try {
            Integer courseId = Integer.parseInt(courseIdStr);
            boolean success = enrollmentService.enrollCourse(userId, courseId);
            if (success) {
                response.getWriter().write("{\"success\":true,\"message\":\"选课成功\",\"courseId\":" + courseId + "}");
            } else {
                response.getWriter().write("{\"success\":false,\"message\":\"选课失败：课程已满或已选\",\"courseId\":" + courseId + "}");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("{\"success\":false,\"message\":\"课程ID格式错误\"}");
        }
    }
}
