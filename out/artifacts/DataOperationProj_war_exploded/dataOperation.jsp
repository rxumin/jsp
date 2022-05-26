<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>test</title>
    <style>
      table{
        margin: 0 auto;
      }
      table td{
        margin: 0 auto;
        width: 150px;
        font-size: large;
      }
    </style>
  </head>
  <body>
  <a href="/upload">属性文件读取数据到数据库</a>
  <br>
  <hr>
  <table border="1" cellspacing=0>
    <caption><strong>学生成绩单</strong></caption>
    <tr>
      <td>学号</td>
      <td>姓名</td>
      <td>性别</td>
      <td>专业</td>
      <td>籍贯</td>
      <td colspan="2">操作</td>
    </tr>

    <c:forEach items="${list}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.sex}</td>
        <td>${student.major}</td>
        <td>${student.hometown}</td>
        <td>
          <a href="/find?method=find&id=${student.id}">修改</a>
        </td>
        <td>
          <a href="/delete?id=${student.id}">删除</a>
        </td>
      </tr>
    </c:forEach>
    <a href="./addStudent.jsp">添加学生信息</a>
  </table>
  </body>
</html>
