<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath %>" />
	<title>用户中心</title>
</head>
<body>
    <div id="userPanel">
        <c:choose>
            <c:when test="${user == null || user.id == null }">
				用户未登录<br />
                <a href="login">登录</a><br />
                <a href="register">注册</a><br />
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <td>Id:</td>
                        <td>${user.id }</td>
                    </tr>
                    <tr>
                        <td>用户名:</td>
                        <td>${user.userName }</td>
                    </tr>
                    <tr>
                        <td>真实姓名:</td>
                        <td>${user.realName }</td>
                    </tr>
                    <tr>
                        <td>性别:</td>
                        <td>${user.sex }</td>
                    </tr>
                    <tr>
                        <td>学校id:</td>
                        <td>${user.school.id }</td>
                    </tr>
                    <tr>
                        <td>学校名:</td>
                        <td>${user.school.name }</td>
                    </tr>
                </table>
                <a href="editInformation">修改资料</a><br />
                <a href="logout">退出登录</a><br />
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>