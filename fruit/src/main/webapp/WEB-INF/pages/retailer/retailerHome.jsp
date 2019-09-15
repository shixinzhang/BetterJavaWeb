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
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        #menuContent a {
            text-decoration: none;
            color: #ffffff;
        }

        .c {
            border-style: solid;
            width: 200px;
            height: 130px;
            /*margin: 4 23 0 23;*/
            border-radius: 5px;
            display: block;
            background: #ffffff;
            margin: 10% auto;
        }

        .mask {
            width: 100%;
            height:100%;
            position: absolute;
            background: rgba(0,0,0,.3);
            display: none;
        }

        .title {
            background-color: #173e65;height: 20px;
            color: #ffffff;
            font-size: 12px;
            padding-left: 7px;
        }
    </style>
    <%--引入 jquery--%>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <%--使用 jquery--%>
    <script type="text/javascript">

        $(document).ready(function(){
            $("button").click(function () {
               $(this).hide();
            });
        });

        /**
         * 编辑零售商信息
         * @param id
         */
        function editRetailer(id) {
            var message = "{'id': '"+id+"'}";
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/retailer/editRetailer.action',
                contentType: 'application/json;charset=utf-8',
                data: message,
                success:function(data) {
                    //返回结果
                    $("#editName").val(data["name"]);
                    $("#editTelephone").val(data["telephone"]);
                    $("#editAddress").val(data["address"]);
                    $("#retailerId").val(data["retailerId"]);
                    $("#editStatus").val(data["status"]);
                    $("#eStatus").val(data["status"]);

                    //显示弹出框
                    $(".mask").css("display", "block");

                    //引入分页信息到该 form 表单
                    $("#eStartPage").val($("#startPage").val());
                    $("#eCurrentPage").val($("#currentPage").val());
                    $("#ePageSize").val($("#pageSize").val());
                }
            })
        }

        /**
         * 删除零售商信息
         * @param id
         */
        function deleteRetailer(id) {
//            alert("id: " + id);

            var message = "{'id':'" + id + "'}";
            $.ajax({
                type: 'post',
                url: '${pageContext.request.contextPath}/retailer/delete.action',
                contentType: 'application/json;charset=utf-8',
                data: message,
                success:function (data) {
                    alert("delete success")
                }
            })
        }

        function cancelEdit() {
            $(".mask").css("display","none");
        }

        function changeStatus() {
            var value = document.getElementById("indexStatus").value;
//            alert(value)
            document.getElementById("listStatus").value = value;
        }

        function changeEditStatus() {
            var value = document.getElementById("eStatus").value;
//            alert(value);
            document.getElementById("editStatus").value = value;
        }

        //显示分页信息
        function init() {
            var countNumber = document.getElementById("countNumber").value;
            var sumPageNumber = document.getElementById("sumPageNumber").value;
            var currentPage = document.getElementById("currentPage").value;

            var info = "一共<font color='blue'>" + countNumber + "</font>条数据," +
                "共<font color='blue'>" + sumPageNumber + "</font>页," +
                "当前第<font color='blue'> " + currentPage + "</font>页";
            document.getElementById("pageInfo").innerHTML = info;
        }

        function toPrePage() {
//            获取当前页码
            var currentPageObject = document.getElementById("currentPage");
//            这个 element 类型不是 text，所以需要解析一下
            var currentPage = parseInt(currentPageObject.value);
            if (currentPage == 1) {
                alert("当前已是第一页！");
            } else {
//                修改当前页数
                currentPageObject.value = currentPage - 1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject = document.getElementById("startPage");
                //修改请求位置
                startPageObject.value = parseInt(startPageObject.value) - pageSize;

                document.getElementById("listForm").submit();
            }
        }

        function toNextPage() {
//            获取当前页码
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            var sumPage = parseInt(document.getElementById("sumPageNumber").value);
            if (currentPage >= sumPage) {
                alert("当前已是最后一页！");
            } else {
//                修改当前页数
                currentPageObject.value = currentPage + 1;
                var pageSize = parseInt(document.getElementById("pageSize").value);
                var startPageObject = document.getElementById("startPage");
                //修改请求位置
                startPageObject.value = parseInt(startPageObject.value) + pageSize;

                document.getElementById("listForm").submit();
            }
        }

        function toLocationPage() {
            //要跳转去的页数
            var pageNumber = document.getElementById("pageNumber").value;
//            获取当前页码
            var currentPageObject = document.getElementById("currentPage");
            var currentPage = parseInt(currentPageObject.value);
            var sumPage = parseInt(document.getElementById("sumPageNumber").value);
            if (pageNumber == null || pageNumber == "") {
                alert("未输入目的页");
            } else {
                pageNumber = parseInt(pageNumber);
                if (pageNumber < 1) {
                    alert("数据已到顶");
                } else if (pageNumber > sumPage) {
                    alert("数据已到底");
                } else {
//                修改当前页数
                    currentPageObject.value = pageNumber;
                    var pageSize = parseInt(document.getElementById("pageSize").value);
                    var startPageObject = document.getElementById("startPage");
                    //修改请求位置
                    startPageObject.value = (pageNumber - 1 ) * pageSize;

                    document.getElementById("listForm").submit();
                }
            }
        }
    </script>
</head>
<body onload="init()">
<%@ include file="../menu.jsp" %>
<br>

<%--修改信息的浮层--%>
<div class="mask">
    <div class="c">
        <div class="title">
            修改信息
            <font style="float: right;padding-right: 10px" onclick="cancelEdit()">
                x
            </font>
        </div>

        <form action="/retailer/edit.action" method="post" id="editForm">
            姓名：
            <input type="text" id="editName" name="name" style="width: 120px"> <br>
            手机：
            <input type="text" id="editTelephone" name="telephone" style="width: 120px"><br>
            地址：
            <input type="text" id="editAddress" name="address" style="width: 120px"><br>
            状态：
            <select id="eStatus" onchange="changeEditStatus()">
                <option value=-1 selected="selected">全部</option>
                <option value=1>启用</option>
                <option value=0>停用</option>
            </select>
            <br>

            <input type="hidden" name="retailerId" id="retailerId">
            <input type="hidden" name="status" id="editStatus">
            <input type="hidden" name="startPage" id="eStartPage" value="${startPage}">
            <input type="hidden" name="currentPage" id="eCurrentPage" value="${currentPage}">
            <input type="hidden" name="pageSize" id="ePageSize" value="${pageSize}">

            <input type="submit" value="提交" style="background-color: #173e65; color: #ffffff; width: 70px">

            <%--显示错误信息--%>
        </form>
    </div>
</div>

<form action="/retailer/list.action" method="post" id="listForm">
    姓名：
    <input type="text" name="name" style="width: 120px">
    手机：
    <input type="text" name="telephone" style="width: 120px">
    地址：
    <input type="text" name="address" style="width: 120px">
    状态：
    <select id="indexStatus" onchange="changeStatus()">
        <option value=-1 selected="selected">全部</option>
        <option value=1>启用</option>
        <option value=0>停用</option>
    </select>
    创建日期：
    <input type="datetime" name="createTime">

    <input type="submit" value="搜索" style="background-color: #173e65; color: #ffffff; width: 70px">

    <%--显示错误信息--%>
    <c:if test="${errorMsg}">
        <span style="color: red">${errorMsg}</span>
    </c:if>

    <%--隐藏分页信息，方便 js 获取--%>
    <input type="hidden" name="startPage" id="startPage" value="${startPage}">
    <input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
    <input type="hidden" name="pageSize" id="pageSize" value="${pageSize}">
    <input type="hidden" name="status" id="listStatus" value=${listStatus}>
    <input type="hidden" name="sumPageNumber" id="sumPageNumber" value="${sumPageNumber}">
    <input type="hidden" name="countNumber" id="countNumber" value="${countNumber}">
</form>

<hr style="margin-top: 10px">

<c:if test="${list==null}">
    <b>搜索结果为空！ </b>
</c:if>

<c:if test="${list != null}">
    <table style="margin-top: 10px; width: 700px; text-align: center" border="1">
        <tr>
                <%--<tb>????</tb>--%>
            <td>序号</td>
            <td>姓名</td>
            <td>手机号</td>
            <td>地址</td>
            <td>状态</td>
            <td>创建日期</td>
            <td>操作</td>
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
                        <span style="color: red">停用</span>
                    </c:if>
                </td>

                <td>${item.createTime}</td>

                <td>
                    <a onclick="editRetailer('${item.retailerId}')">编辑</a>|
                    <a onclick="deleteRetailer('${item.retailerId}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<div style="margin-top: 10px">
    <a onclick="toPrePage()">上一页</a>
    <a onclick="toNextPage()">下一页</a>
    <input type="text" id="pageNumber" style="width: 50px">
    <button onclick="toLocationPage()">go</button>

    <%--用于保存当前页数的信息--%>
    <div id="pageInfo"></div>
</div>
</body>
</html>
