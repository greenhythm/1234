package com.education.service;

import com.education.model.Enrollment;
import java.util.List;

/**
 * 选课业务逻辑接口 (Enrollment Service Interface)
 */
public interface EnrollmentService {
    /**
     * 学生选课
     */
    boolean enrollCourse(Integer userId, Integer courseId);

    /**
     * 学生退选课程
     */
    boolean dropCourse(Integer userId, Integer courseId);

    /**
     * 获取学生已选课程
     */
    List<Enrollment> getStudentCourses(Integer userId);

    /**
     * 获取课程已选学生
     */
    List<Enrollment> getCoursesStudents(Integer courseId);

    /**
     * 检查学生是否已选课
     */
    boolean isStudentEnrolled(Integer userId, Integer courseId);
}
