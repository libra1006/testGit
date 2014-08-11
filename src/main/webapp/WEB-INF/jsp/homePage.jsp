<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<table border="1">
				<tr>
					<td>商品id</td>
					<td>商品名</td>
					<td>价格</td>
					<td>描述</td>
					<td>发布日期</td>
					<td>卖家ID</td>
					<td>卖家用戶名</td>
					<td>卖家姓名</td>
				</tr>
			<c:forEach var="goods" items="${goodsList }">
				<tr>
					<td>${goods.id}</td>
					<td>${goods.name}</td>
					<td>${goods.price}</td>
					<td>${goods.description}</td>
					<td>${goods.releaseDate}</td>
					<td>${goods.seller.id}</td>
					<td>${goods.seller.userName}</td>
					<td>${goods.seller.realName}</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<a href="releaseGoods">发布商品</a>
	</body>
</html>