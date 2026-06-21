package com.education.dao.impl;

import com.education.dao.EnrollmentDAO;
import com.education.model.Enrollment;
import com.education.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 选课数据访问实现类 (Enrollment DAO Implementation)
 */
public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Override
    public boolean enroll(Integer userId, Integer courseId) {
        String sql = "INSERT INTO enrollments (user_id, course_id, status) VALUES (?, ?, 'enrolled')";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
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

    @Override
    public boolean dropCourse(Integer userId, Integer courseId) {
        String sql = "UPDATE enrollments SET status = 'dropped' WHERE user_id = ? AND course_id = ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
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

    @Override
    public List<Enrollment> getEnrollmentsByUserId(Integer userId) {
        String sql = "SELECT e.*, c.* FROM enrollments e JOIN courses c ON e.course_id = c.course_id WHERE e.user_id = ? AND e.status = 'enrolled' ORDER BY e.enrolled_at DESC";
        List<Enrollment> enrollments = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = mapResultSetToEnrollment(rs);
                enrollments.add(enrollment);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return enrollments;
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(Integer courseId) {
        String sql = "SELECT e.*, u.* FROM enrollments e JOIN users u ON e.user_id = u.user_id WHERE e.course_id = ? AND e.status = 'enrolled'";
        List<Enrollment> enrollments = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, courseId);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
                enrollment.setUserId(rs.getInt("user_id"));
                enrollment.setCourseId(rs.getInt("course_id"));
                enrollment.setEnrolledAt(rs.getTimestamp("enrolled_at"));
                enrollment.setStatus(rs.getString("status"));
                enrollments.add(enrollment);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return enrollments;
    }

    @Override
    public boolean isEnrolled(Integer userId, Integer courseId) {
        String sql = "SELECT COUNT(*) FROM enrollments WHERE user_id = ? AND course_id = ? AND status = 'enrolled'";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, courseId);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                rs.close();
                pstmt.close();
                return true;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        String sql = "SELECT * FROM enrollments WHERE status = 'enrolled'";
        List<Enrollment> enrollments = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Enrollment enrollment = new Enrollment();
                enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
                enrollment.setUserId(rs.getInt("user_id"));
                enrollment.setCourseId(rs.getInt("course_id"));
                enrollment.setEnrolledAt(rs.getTimestamp("enrolled_at"));
                enrollment.setStatus(rs.getString("status"));
                enrollments.add(enrollment);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return enrollments;
    }

    private Enrollment mapResultSetToEnrollment(ResultSet rs) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(rs.getInt("enrollment_id"));
        enrollment.setUserId(rs.getInt("user_id"));
        enrollment.setCourseId(rs.getInt("course_id"));
        enrollment.setEnrolledAt(rs.getTimestamp("enrolled_at"));
        enrollment.setGrade(rs.getString("grade"));
        enrollment.setStatus(rs.getString("status"));
        return enrollment;
    }
}
