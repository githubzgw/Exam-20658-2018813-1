<%@ page import="java.util.List" %>
<%@ page import="com.dao.filmDao" %>
<%@ page import="com.entity.film" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<film> filmlist = (List<film>) request.getAttribute("filmlist");
    System.out.println(filmlist);
%>
<center>
    <a href="add">增加操作</a>
    <table style="width:auto;border: 1px">
        <tr>
            <td colspan="2" align="center">数据操作</td>
            <td align="center">film_id</td>
            <td align="center">title</td>
            <td align="center">description</td>
            <td align="center">language</td>
        </tr>
        <%for (film film: filmlist) {%>
        <tr>
            <td align="center"><div style="height: 20px"><a href="delete?id=<%=film.getFilm_id()%>">删除操作</a></div></td>
            <td align="center"><div style="height: 20px"><a href="update?id=<%=film.getFilm_id()%>">更新操作</a></div></td>
            <td align="center"><div style="height: 20px"><%=film.getFilm_id()%></div></td>
            <td align="center"><div style="height: 20px"><%=film.getTitle()%></div></td>
            <td align="center"><div style="height: 20px"><%=film.getDescription()%></div></td>
            <td align="center"><div style="height: 20px"><%=film.getLanguage()%></div></td>
        </tr>
        <%}%>

    </table>
</center>

</body>
</html>
