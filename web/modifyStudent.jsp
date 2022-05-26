<%--
  Created by IntelliJ IDEA.
  User: arrogant
  Date: 2022-05-16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生页面</title>
    <style>
        .box{
            margin-top: 20px;
            width: 300px;
            height: 500px;

        }
        form{
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="box">
    <form action="/update" method="get" >
        学生学号:  <input type="text" name="id" disabled value="${student.id}">
        <br>
        <br>
        姓名:  <input type="text" name="name" value="${student.name}">
        <br>
        <br>
        性别:  <input type="text" name="sex" value="${student.sex}">

        <br>
        <br>
        专业:  <input type="text" name="major" value="${student.major}">
        <br>
        <br>
        籍贯:  <input type="text" name="hometown" value="${student.hometown}">
        <br>
        <br>
        <input type="submit" value="提交">
        
    </form>
</div>

</body>
</html>

