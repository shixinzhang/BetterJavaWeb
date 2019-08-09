<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Home</title>
    </head>

    <body>
        Hello,
        ${tel}, ${user},

        <c:if test="${user!=null}">
            ${user.username}<br/>
            ${user.name}<br/>
            ${user.userid}<br/>
            ${user.password}<br/>
            ${user.telephone}<br/>
        </c:if>
    </body>
</html>