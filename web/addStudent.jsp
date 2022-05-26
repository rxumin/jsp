<%--
  Created by IntelliJ IDEA.
  User: arrogant
  Date: 2022-05-16
  Time: 21:27
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
    <form action="/add" method="post" >
        学生学号:  <input type="text" name="id">
        <br>
        <br>
        姓名:  <input type="text" name="name">
        <br>
        <br>
        性别:  <input type="text" name="sex">

        <br>
        <br>
        专业:  <input type="text" name="major">
        <br>
        <br>
        籍贯:  <input type="text" name="hometown">
        <br>
        <br>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
