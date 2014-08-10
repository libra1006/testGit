<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发布商品</title>
</head>
	<body>
		<h2>发布商品</h2>
		<form action="releaseGoods" method="post">
			<table>
				<tr>
					<td>商品名：</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>分类Id：</td>
					<td><input type="text" name="goodsTypeId"/></td>
				</tr>
				<tr>
					<td>价格：</td>
					<td><input type="text" name="price"/></td>
				</tr>
				<tr>
					<td>学校Id：</td>
					<td><input type="text" name="schoolId"/></td>
				</tr>
				<tr>
					<td>描述：</td>
					<td><input type="text" name="description"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="发布"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		跳转至<a href="home">主界面</a>
	</body>
</html>