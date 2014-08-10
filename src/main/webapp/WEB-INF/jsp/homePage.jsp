<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
	<body>
		<div id="userPanel">
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
		</div>
		<div id="goodsPanel">
			
			
		</div>
		<a href="releaseGoods">发布商品</a>
	</body>
</html>