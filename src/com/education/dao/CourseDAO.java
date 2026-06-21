package com.education.dao;

import com.education.model.Course;
import java.util.List;

/**
 * 课程数据访问接口 (Course DAO Interface)
 */
public interface CourseDAO {
    /**
     * 添加课程
     */
    boolean addCourse(Course course);

    /**
     * 删除课程
     */
    boolean deleteCourse(Integer courseId);

    /**
     * 更新课程
     */
    boolean updateCourse(Course course);

    /**
     * 根据ID查询课程
     */
    Course getCourseById(Integer courseId);

    /**
     * 根据课程代码查询课程
     */
    Course getCourseByCourseCode(String courseCode);

    /**
     * 查询所有课程
     */
    List<Course> getAllCourses();

    /**
     * 查询指定学期的课程
     */
    List<Course> getCoursesBySemester(String semester);

    /**
     * 更新已选人数
     */
    boolean updateEnrolledCount(Integer courseId, Integer count);
}
