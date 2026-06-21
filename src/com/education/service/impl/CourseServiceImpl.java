package com.education.service.impl;

import com.education.service.CourseService;
import com.education.dao.CourseDAO;
import com.education.dao.impl.CourseDAOImpl;
import com.education.model.Course;
import java.util.List;

/**
 * 课程业务逻辑实现类 (Course Service Implementation)
 */
public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    @Override
    public List<Course> getCoursesBySemester(String semester) {
        return courseDAO.getCoursesBySemester(semester);
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseDAO.getCourseById(courseId);
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        return courseDAO.getCourseByCourseCode(courseCode);
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        return courseDAO.deleteCourse(courseId);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }
}
