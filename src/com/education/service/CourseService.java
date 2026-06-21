package com.education.service;

import com.education.model.Course;
import java.util.List;

/**
 * 课程业务逻辑接口 (Course Service Interface)
 */
public interface CourseService {
    /**
     * 获取所有课程
     */
    List<Course> getAllCourses();

    /**
     * 根据学期获取课程
     */
    List<Course> getCoursesBySemester(String semester);

    /**
     * 根据ID获取课程
     */
    Course getCourseById(Integer courseId);

    /**
     * 根据课程代码获取课程
     */
    Course getCourseByCourseCode(String courseCode);

    /**
     * 添加课程
     */
    boolean addCourse(Course course);

    /**
     * 删除课程
     */
    boolean deleteCourse(Integer courseId);

    /**
     * 更新课程信息
     */
    boolean updateCourse(Course course);
}
