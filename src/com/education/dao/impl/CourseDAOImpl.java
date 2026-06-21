package com.education.dao.impl;

import com.education.dao.CourseDAO;
import com.education.model.Course;
import com.education.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程数据访问实现类 (Course DAO Implementation)
 */
public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean addCourse(Course course) {
        String sql = "INSERT INTO courses (course_code, course_name, instructor, credits, capacity, schedule, location, description, semester) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getCourseCode());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getInstructor());
            pstmt.setInt(4, course.getCredits() != null ? course.getCredits() : 3);
            pstmt.setInt(5, course.getCapacity() != null ? course.getCapacity() : 50);
            pstmt.setString(6, course.getSchedule());
            pstmt.setString(7, course.getLocation());
            pstmt.setString(8, course.getDescription());
            pstmt.setString(9, course.getSemester());
            
            int result = pstmt.executeUpdate();
            pstmt.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            
            int result = pstmt.executeUpdate();
            pstmt.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name = ?, instructor = ?, credits = ?, capacity = ?, schedule = ?, location = ?, description = ?, semester = ? WHERE course_id = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getInstructor());
            pstmt.setInt(3, course.getCredits());
            pstmt.setInt(4, course.getCapacity());
            pstmt.setString(5, course.getSchedule());
            pstmt.setString(6, course.getLocation());
            pstmt.setString(7, course.getDescription());
            pstmt.setString(8, course.getSemester());
            pstmt.setInt(9, course.getCourseId());
            
            int result = pstmt.executeUpdate();
            pstmt.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    @Override
    public Course getCourseById(Integer courseId) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Course course = mapResultSetToCourse(rs);
                rs.close();
                pstmt.close();
                return course;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public Course getCourseByCourseCode(String courseCode) {
        String sql = "SELECT * FROM courses WHERE course_code = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseCode);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Course course = mapResultSetToCourse(rs);
                rs.close();
                pstmt.close();
                return course;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses ORDER BY course_code";
        List<Course> courses = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Course course = mapResultSetToCourse(rs);
                courses.add(course);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesBySemester(String semester) {
        String sql = "SELECT * FROM courses WHERE semester = ? ORDER BY course_code";
        List<Course> courses = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, semester);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Course course = mapResultSetToCourse(rs);
                courses.add(course);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return courses;
    }

    @Override
    public boolean updateEnrolledCount(Integer courseId, Integer count) {
        String sql = "UPDATE courses SET enrolled_count = ? WHERE course_id = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setInt(2, courseId);
            
            int result = pstmt.executeUpdate();
            pstmt.close();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    private Course mapResultSetToCourse(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setCourseCode(rs.getString("course_code"));
        course.setCourseName(rs.getString("course_name"));
        course.setInstructor(rs.getString("instructor"));
        course.setCredits(rs.getInt("credits"));
        course.setCapacity(rs.getInt("capacity"));
        course.setEnrolledCount(rs.getInt("enrolled_count"));
        course.setSchedule(rs.getString("schedule"));
        course.setLocation(rs.getString("location"));
        course.setDescription(rs.getString("description"));
        course.setSemester(rs.getString("semester"));
        course.setCreatedAt(rs.getTimestamp("created_at"));
        course.setUpdatedAt(rs.getTimestamp("updated_at"));
        return course;
    }
}
