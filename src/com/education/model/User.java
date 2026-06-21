package com.education.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户实体类 (User Entity Class)
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String studentName;
    private String studentId;
    private String major;
    private String phone;
    private String gender;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean isActive;

    public User() {
    }

    public User(String username, String password, String email, String studentName, String studentId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.studentName = studentName;
        this.studentId = studentId;
    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username='" + username + "'" + "}";
    }
}
