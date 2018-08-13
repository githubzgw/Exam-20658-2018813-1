<%@ page import="com.entity.language" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Zhao Guowei
  Date: 2018/8/13
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<language> languagelist = (List<language>) request.getAttribute("languagelist");
    System.out.println(languagelist);
%>
<center>
    <form action="add" method="post" onsubmit="check(this)">
        <table width="450">
            <tr>
                <td align="center" colspan="2">
                    <h2>添加电影</h2>
                    <hr>
                </td>
            </tr>
<%--            <tr>
                <td align="right">film_id：</td>
                <td><input type="text" name="film_id"></td>
            </tr>--%>
            <tr>
                <td align="right">title：</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td align="right">description：</td>
                <td><input type="text" name="description" /></td>
            </tr>
            <tr>
                <td align="right">language：</td>
                <td>
                    <select name="language" id="">
                        <%for (language language: languagelist) {%>
                        <option value="<%=language.getLanguage_id()%>"><%=language.getName()%></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="添　加">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
