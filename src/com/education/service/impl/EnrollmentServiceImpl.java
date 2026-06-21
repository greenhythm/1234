package com.education.service.impl;

import com.education.service.EnrollmentService;
import com.education.dao.EnrollmentDAO;
import com.education.dao.CourseDAO;
import com.education.dao.impl.EnrollmentDAOImpl;
import com.education.dao.impl.CourseDAOImpl;
import com.education.model.Course;
import com.education.model.Enrollment;
import java.util.List;

/**
 * 选课业务逻辑实现类 (Enrollment Service Implementation)
 */
public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public boolean enrollCourse(Integer userId, Integer courseId) {
        // 检查学生是否已选此课程
        if (enrollmentDAO.isEnrolled(userId, courseId)) {
            return false;
        }
        
        // 检查课程是否有余位
        Course course = courseDAO.getCourseById(courseId);
        if (course == null || !course.hasAvailableSeat()) {
            return false;
        }
        
        // 进行选课
        boolean success = enrollmentDAO.enroll(userId, courseId);
        if (success) {
            // 更新课程已选人数
            int newCount = course.getEnrolledCount() + 1;
            courseDAO.updateEnrolledCount(courseId, newCount);
        }
        return success;
    }

    @Override
    public boolean dropCourse(Integer userId, Integer courseId) {
        boolean success = enrollmentDAO.dropCourse(userId, courseId);
        if (success) {
            // 更新课程已选人数
            Course course = courseDAO.getCourseById(courseId);
            if (course != null && course.getEnrolledCount() > 0) {
                int newCount = course.getEnrolledCount() - 1;
                courseDAO.updateEnrolledCount(courseId, newCount);
            }
        }
        return success;
    }

    @Override
    public List<Enrollment> getStudentCourses(Integer userId) {
        return enrollmentDAO.getEnrollmentsByUserId(userId);
    }

    @Override
    public List<Enrollment> getCoursesStudents(Integer courseId) {
        return enrollmentDAO.getEnrollmentsByCourseId(courseId);
    }

    @Override
    public boolean isStudentEnrolled(Integer userId, Integer courseId) {
        return enrollmentDAO.isEnrolled(userId, courseId);
    }
}
