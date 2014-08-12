<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
</head>
	<body>
		<h2>注册</h2>
		<form action="registerAction" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="text" name="password"/></td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" name="realName"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						男<input type="radio" name="sex" value="0" checked="checked"/>
						女<input type="radio" name="sex" value="1"/><br/>
					</td>
				</tr>
				<tr>
					<td>学校Id：</td>
					<td><input type="text" name="schoolId"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		跳转至<a href="login">登录界面</a>
	</body>
</html>