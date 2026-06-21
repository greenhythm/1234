# 学生登录注册选课系统 (Student Login/Registration Course Selection System)

## 项目概述 (Project Overview)
一个基于Java Web的学生登录注册选课系统，满足课程期末考察要求。

### 功能需求 (Features Required)
- ✅ 用户登录功能 (User Login)
- ✅ 用户注册功能 (User Registration)
- ✅ 课程选课功能 (Course Selection)
- ✅ 美观的用户界面 (Beautiful UI)

## 技术栈 (Tech Stack)

### 前端 (Frontend)
- HTML5
- CSS3
- JavaScript (Vanilla JS)
- JSP

### 后端 (Backend)
- Java Servlet
- MVC + 三层架构 (MVC + Three-tier Architecture)
  - Controller: Servlet 处理HTTP请求
  - Service: 业务逻辑层
  - DAO: 数据访问层
- 接口类与实现类 (Interface & Implementation Classes)
- Cookie & Session 管理

### 数据库 (Database)
- MySQL / SQLite (支持CRUD操作)

### 开发工具 (Development Tools)
- Java JDK 8+
- Eclipse / IntelliJ IDEA
- Tomcat 9+
- MySQL Workbench / DBeaver (数据库可视化工具)

## 项目结构 (Project Structure)

```
StudentCourseSelectionSystem/
├── src/
│   ├── com/
│   │   └── education/
│   │       ├── controller/      # Servlet Controller层
│   │       ├── service/         # Business Logic 业务逻辑层
│   │       ├── dao/             # Data Access Object 数据访问层
│   │       ├── model/           # 数据模型
│   │       ├── util/            # 工具类
│   │       └── filter/          # 过滤器
│   └── database/
│       └── init.sql             # 数据库初始化脚本
├── WebContent/
│   ├── index.jsp                # 首页
│   ├── login.jsp                # 登录页面
│   ├── register.jsp             # 注册页面
│   ├── courses.jsp              # 选课页面
│   ├── dashboard.jsp            # 学生仪表板
│   ├── css/
│   │   └── style.css            # 样式表
│   ├── js/
│   │   ├── login.js             # 登录脚本
│   │   ├── register.js          # 注册脚本
│   │   └── courses.js           # 选课脚本
│   └── images/                  # 图片资源
├── WEB-INF/
│   ├── web.xml                  # Web应用配置
│   └── lib/                     # 依赖库
└── docs/
    ├── 数据库设计.md
    ├── API文档.md
    └── 使用说明.md
```

## 数据库设计 (Database Design)

### 用户表 (Users Table)
```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    student_id VARCHAR(20) UNIQUE NOT NULL,
    major VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 课程表 (Courses Table)
```sql
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_code VARCHAR(20) UNIQUE NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    instructor VARCHAR(100) NOT NULL,
    credits INT,
    capacity INT,
    enrolled_count INT DEFAULT 0,
    schedule VARCHAR(200),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 选课表 (Course Enrollment Table)
```sql
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    grade VARCHAR(5),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    UNIQUE KEY unique_enrollment (user_id, course_id)
);
```

## 快速开始 (Quick Start)

### 1. 环境配置 (Environment Setup)
- 安装 JDK 8 或更高版本
- 安装 Eclipse / IntelliJ IDEA
- 安装 Tomcat 9 或更高版本
- 安装 MySQL 数据库

### 2. 数据库初始化 (Database Initialization)
```bash
mysql -u root -p
source database/init.sql
```

### 3. 项目导入 (Import Project)
- 在Eclipse中创建Dynamic Web Project
- 复制所有文件到项目目录
- 配置Tomcat服务器

### 4. 运行项目 (Run Project)
- 右键项目 → Run on Server
- 访问 http://localhost:8080/StudentCourseSelectionSystem

## 功能说明 (Features Description)

### 登录功能 (Login)
- 用户名/密码登录
- Session管理
- 记住登录状态
- 登出功能

### 注册功能 (Registration)
- 账户信息填写
- 邮箱验证
- 密码强度检验
- 数据库存储

### 选课功能 (Course Selection)
- 查看可选课程列表
- 选择/退选课程
- 已选课程管理
- 选课人数限制

## API端点 (API Endpoints)

| 方法 | 端点 | 描述 |
|------|------|------|
| POST | /login | 用户登录 |
| POST | /register | 用户注册 |
| GET | /courses | 获取课程列表 |
| POST | /enroll | 选择课程 |
| POST | /drop | 退选课程 |
| GET | /myenrollments | 获取我的选课 |
| POST | /logout | 登出 |

## 注意事项 (Important Notes)

- 密码需使用MD5或其他加密方式存储
- 实现登录会话管理
- 课程选人数限制需在数据库和业务逻辑层检查
- 前后端验证均需实现
- 代码需有适当的异常处理
- 时间要求：期末考察前完成

## 运行环境检查清单 (Environment Checklist)

- [ ] JDK已安装并配置PATH
- [ ] Eclipse/IDEA已安装
- [ ] Tomcat已安装并配置
- [ ] MySQL已安装
- [ ] 数据库可视化工具已安装
- [ ] 项目已导入IDE
- [ ] 数据库已初始化
- [ ] Tomcat已在IDE中配置

## 联系与支持 (Support)

如有问题，请参考项目文档或联系课程讲师。

---

**项目创建时间**: 2026-06-21  
**期末考察时间**: 第16周  
**开发环境**: Local Development with Tomcat
