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
- MySQL (推荐)

### 开发工具 (Development Tools)
- Java JDK 8+
- Eclipse / IntelliJ IDEA
- Tomcat 9+
- MySQL / DBeaver

## 快速开始 (Quick Start)

### 1. 环境配置
- 安装 JDK 8+
- 安装 Eclipse 或 IntelliJ IDEA
- 安装 Tomcat 9+
- 安装 MySQL

### 2. 数据库初始化
```bash
mysql -u root -p
source database/init.sql
```

### 3. 项目导入
- 在IDE中创建Dynamic Web Project
- 配置Tomcat服务器
- 配置数据库连接

### 4. 运行项目
- 右键项目 → Run on Server
- 访问 http://localhost:8080/StudentCourseSelectionSystem

## 核心功能

### 1. 用户认证 (Authentication)
- 注册新账户
- 用户登录
- Session管理
- 用户登出

### 2. 课程管理 (Course Management)
- 查看可选课程列表
- 选择课程
- 退选课程
- 查看已选课程

### 3. 数据持久化 (Data Persistence)
- 用户信息存储
- 课程信息管理
- 选课记录保存

## 数据库表设计

### users表
- user_id (主键)
- username
- password
- email
- student_name
- student_id
- major

### courses表
- course_id (主键)
- course_code
- course_name
- instructor
- credits
- capacity
- enrolled_count
- schedule

### enrollments表
- enrollment_id (主键)
- user_id (外键)
- course_id (外键)
- enrolled_at
- grade

---

**创建时间**: 2026-06-21
**考察时间**: 第16周
