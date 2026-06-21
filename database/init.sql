-- 学生登录注册选课系统 数据库初始化脚本
CREATE DATABASE IF NOT EXISTS student_course_system;
USE student_course_system;

-- 用户表
CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    student_id VARCHAR(20) UNIQUE NOT NULL,
    major VARCHAR(100),
    phone VARCHAR(20),
    gender VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 课程表
CREATE TABLE IF NOT EXISTS courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    instructor VARCHAR(100) NOT NULL,
    credits INT DEFAULT 3,
    capacity INT DEFAULT 50,
    enrolled_count INT DEFAULT 0,
    schedule VARCHAR(200),
    location VARCHAR(100),
    description TEXT,
    semester VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 选课表
CREATE TABLE IF NOT EXISTS enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    grade VARCHAR(5),
    status VARCHAR(20) DEFAULT 'enrolled',
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE,
    UNIQUE KEY unique_enrollment (user_id, course_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 创建索引
CREATE INDEX idx_username ON users(username);
CREATE INDEX idx_student_id ON users(student_id);
CREATE INDEX idx_course_code ON courses(course_code);
CREATE INDEX idx_enrollment_user ON enrollments(user_id);
CREATE INDEX idx_enrollment_course ON enrollments(course_id);

-- 插入示例用户
INSERT INTO users (username, password, email, student_name, student_id, major, gender) VALUES
('student001', 'e10adc3949ba59abbe56e057f20f883e', 'student001@example.com', '张三', '20220001', '计算机科学', '男'),
('student002', 'e10adc3949ba59abbe56e057f20f883e', 'student002@example.com', '李四', '20220002', '软件工程', '女'),
('student003', 'e10adc3949ba59abbe56e057f20f883e', 'student003@example.com', '王五', '20220003', '计算机科学', '男');

-- 插入示例课程
INSERT INTO courses (course_code, course_name, instructor, credits, capacity, schedule, location, description, semester) VALUES
('CS101', 'Java程序设计基础', '王教授', 3, 50, '周一 10:00-12:00', '教室A101', 'Java基础语言学习', '2026-1'),
('CS102', '数据结构与算法', '李教授', 3, 45, '周二 14:00-16:00', '教室A102', '学习数据结构和算法设计', '2026-1'),
('CS103', '数据库原理', '张教授', 3, 40, '周三 10:00-12:00', '教室A103', 'MySQL和关系型数据库学习', '2026-1'),
('CS104', 'Web开发实战', '刘教授', 3, 55, '周四 14:00-16:00', '教室A104', 'HTML/CSS/JavaScript/JSP实战', '2026-1'),
('CS105', '操作系统原理', '陈教授', 3, 48, '周五 10:00-12:00', '教室A105', '操作系统核心概念学习', '2026-1'),
('CS106', '计算机网络', '杨教授', 3, 50, '周一 14:00-16:00', '教室A106', '网络协议和通信基础', '2026-1'),
('CS107', '软件工程', '赵教授', 3, 45, '周二 10:00-12:00', '教室A107', '软件开发方法论', '2026-1'),
('CS108', '人工智能基础', '吴教授', 3, 40, '周三 14:00-16:00', '教室A108', 'AI和机器学习基础', '2026-1');

-- 插入示例选课数��
INSERT INTO enrollments (user_id, course_id, status) VALUES
(1, 1, 'enrolled'),
(1, 2, 'enrolled'),
(1, 4, 'enrolled'),
(2, 1, 'enrolled'),
(2, 3, 'enrolled'),
(3, 2, 'enrolled'),
(3, 5, 'enrolled');

-- 更新已选人数
UPDATE courses SET enrolled_count = (SELECT COUNT(*) FROM enrollments WHERE courses.course_id = enrollments.course_id AND enrollments.status = 'enrolled');
