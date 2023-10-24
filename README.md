# User Service

User Micro service built using Spring Boot

Database : MySQL

# Initial Setup 

Download and Install
<a href="https://dev.mysql.com/downloads/mysql/" target="_blank">MySQL Community Server</a>
and
<a href="https://dev.mysql.com/downloads/workbench/" target="_blank">MySQL Workbench</a> [Optional]
on your system

* Create  a database and user by executing the following commands
```mysql
create database userservice;
create user userservice;
grant all privileges on userservice.* to userservice;
```
  * That's all, sync project with gradle files and run the spring boot application from your choice of IDE 

