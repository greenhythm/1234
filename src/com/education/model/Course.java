package com.education.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 课程实体类 (Course Entity Class)
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer courseId;
    private String courseCode;
    private String courseName;
    private String instructor;
    private Integer credits;
    private Integer capacity;
    private Integer enrolledCount;
    private String schedule;
    private String location;
    private String description;
    private String semester;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Course() {
    }

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    // Getters and Setters
    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Integer getEnrolledCount() { return enrolledCount; }
    public void setEnrolledCount(Integer enrolledCount) { this.enrolledCount = enrolledCount; }

    public String getSchedule() { return schedule; }
    public void setSchedule(String schedule) { this.schedule = schedule; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    public boolean hasAvailableSeat() {
        return enrolledCount < capacity;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName='" + courseName + "'" + "}";
    }
}
