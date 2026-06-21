package com.education.dao;

import com.education.model.Enrollment;
import java.util.List;

/**
 * 选课数据访问接口 (Enrollment DAO Interface)
 */
public interface EnrollmentDAO {
    /**
     * 学生选课
     */
    boolean enroll(Integer userId, Integer courseId);

    /**
     * 学生退选课程
     */
    boolean dropCourse(Integer userId, Integer courseId);

    /**
     * 查询学生已选课程
     */
    List<Enrollment> getEnrollmentsByUserId(Integer userId);

    /**
     * 查询课程已选学生
     */
    List<Enrollment> getEnrollmentsByCourseId(Integer courseId);

    /**
     * 检查学生是否已选课程
     */
    boolean isEnrolled(Integer userId, Integer courseId);

    /**
     * 查询所有选课记录
     */
    List<Enrollment> getAllEnrollments();
}
