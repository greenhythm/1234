package com.education.controller;

import com.education.service.EnrollmentService;
import com.education.service.impl.EnrollmentServiceImpl;
import com.education.model.Enrollment;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 我的课程Servlet (My Courses Controller)
 */
@WebServlet("/myenrollments")
public class MyEnrollmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentService enrollmentService = new EnrollmentServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 检查登录状态
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            response.sendRedirect("login");
            return;
        }

        // 获取学生已选课程
        List<Enrollment> enrollments = enrollmentService.getStudentCourses(userId);
        request.setAttribute("enrollments", enrollments);
        request.getRequestDispatcher("/jsp/myenrollments.jsp").forward(request, response);
    }
}
