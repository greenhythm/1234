package com.education.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 选课记录实体类 (Enrollment Entity Class)
 */
public class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer enrollmentId;
    private Integer userId;
    private Integer courseId;
    private Timestamp enrolledAt;
    private String grade;
    private String status;

    private User user;
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Integer userId, Integer courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.status = "enrolled";
    }

    // Getters and Setters
    public Integer getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Integer enrollmentId) { this.enrollmentId = enrollmentId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public Timestamp getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(Timestamp enrolledAt) { this.enrolledAt = enrolledAt; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @Override
    public String toString() {
        return "Enrollment{" + "enrollmentId=" + enrollmentId + "}";
    }
}
