# 人事管理系统 (HRMS)

## 概述

通过GDOU实验性课程作业，搭建的前后端分离的项目，具有系统权限管理、人力资源档案管理、薪酬管理功能。
权限细化到按钮级别。
前端：https://github.com/Saktawdi/hrmSys-web-ui

## 特性
依赖少，入门简单

- **Spring Boot**: 利用Spring Boot框架开发强大且可扩展的HRMS。
- **MyBatis**: 使用MyBatis与MySQL数据库无缝集成，确保高效的数据管理。
- **Lombok**: 利用Lombok注解提高代码可读性和简洁性，减少样板代码。
- **Druid**: 利用Druid的连接池功能进行优化的数据库交互。
- **Knife4j**: 使用Knife4j实现简单交互的API文档，简化对HRMS API的理解。
- **Sa-Token**: 使用Sa-Token实现安全可定制的身份验证和授权。
- **JUnit**: 利用JUnit确保代码的可靠性，进行全面的测试。

## 入门指南

1. **先决条件**: 确保您的系统上安装了Java和Maven。

2. **克隆仓库**:
    ```bash
    git clone https://github.com/your-username/hrms.git
    cd hrms
    ```

3. **数据库设置**: 在`application.properties`文件中配置您的MySQL数据库设置。

4. **构建和运行**: 
    ```bash
    mvn clean install
    java -jar target/hrms-1.0.0.jar
    ```

5. **访问API文档**: 访问 [http://localhost:8080/doc.html](http://localhost:8080/doc.html) 查看交互式API文档。

## 贡献

我们欢迎社区的贡献。请随时提出问题，提交拉取请求或提供反馈。

## 许可证

该HRMS项目采用MIT许可证授权 - 有关详细信息，请参阅[LICENSE](LICENSE)文件。

## 致谢

特别感谢那些付出时间和精力使这个HRMS项目成为可能的开发人员和贡献者。

愉快的编码！🚀
