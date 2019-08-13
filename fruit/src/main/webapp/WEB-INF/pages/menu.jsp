<%--
  Created by IntelliJ IDEA.
  User: zhangshixin
  Date: 19/8/13
  Time: 下午10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="menuContent" style="height: 100px;background: #173e65;color: white">
    <h1 style="margin-left: 10px;margin-top: 10px;">水果网络销售平台</h1>
    <br/>

    <div style="margin-left: 10px">
        <a href="${pageContext.request.contextPath}/retailer/list.action?status=-1">货物管理</a>|
        <a href="${pageContext.request.contextPath}/retailer/list.action?status=-1">零售商管理</a>|
        <a href="">购销合同</a>|
        <a href="">用户设置</a>
    </div>

    <div style="background: #cccccc">
        <span style="margin-left: 10px">欢迎您，${sessionScope.user.name}</span>
    </div>
</div>
