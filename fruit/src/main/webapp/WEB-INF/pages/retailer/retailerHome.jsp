<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangshixin
  Date: 19/8/16
  Time: 上午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>零售商管理</title>
    <style >
        * {
            margin:0;
            padding: 0;
        }

        #menuContent a{
            text-decoration: none;
            color: #ffffff;
        }
    </style>
    <script type="text/javascript">
        function changeStatus() {
            var value = document.getElementById("indexStatus").value;
            document.getElementById("value").value = status;
        }
    </script>
</head>
<body>
    <%@ include file="../menu.jsp" %> <br>

    <form action="/retailer/list.action" method="post">
        姓名：
            <input type="text" name="name" style="width: 120px">
        手机：
            <input type="text" name="telephone" style="width: 120px">
        地址：
            <input type="text" name="address" style="width: 120px">
        <br>
        状态：
            <select>
                <option value="-1" selected="selected">全部</option>
                <option value="1">启用</option>
                <option value="0">停用</option>
            </select>
        创建日期：
            <input type="datetime" name="createTime">

        <input type="submit" value="搜索" style="background-color: #173e65; color: #ffffff; width: 70px">

        <c:if test="${errorMsg}">
            <span style="color: red">${errorMsg}</span>
        </c:if>
    </form>

    <hr style="margin-top: 10px">

    <c:if test="${list==null}">
        <b>搜索结果为空！ </b>
    </c:if>

    <c:if test="${list != null}" >
        <table style="margin-top: 10px; width: 700px; text-align: center" border="1">
            <tr>
                <%--<tb>????</tb>--%>
                <td>序号</td><td>姓名</td><td>手机号</td><td>地址</td>
                <td>状态</td><td>创建日期</td><td>操作</td>
            </tr>

            <c:forEach items="${list}" var="item" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${item.name}</td>
                    <td>${item.telephone}</td>
                    <td>${item.address}</td>

                    <%--动态标签--%>
                    <td>
                        <c:if test="${item.status==1}">
                            <span style="color: blue">启用</span>
                        </c:if>
                        <c:if test="${item.status==0}">
                            <span style="color: yellow">停用</span>
                        </c:if>
                    </td>

                    <td>${item.createTime}</td>

                    <td>
                        <a >编辑</a>|
                        <a >删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <div style="margin-top: 10px">
        <a href="">上一页</a>
        <a href="">下一页</a>
        <input type="text" id="pageNumber" style="width: 50px">
        <button>go</button>
    </div>
</body>
</html>
