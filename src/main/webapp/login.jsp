<%--
  Created by IntelliJ IDEA.
  User: Zhao Guowei
  Date: 2018/8/13
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="<%=request.getContextPath()%>/login" method="post" class="list">
        <div class="login_title">用户名登陆</div>
        <input type="text" name="username">
        <input type="submit" class="submit">
    </form>
</center>
</body>
</html>
