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
    	<title>修改资料</title>
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/tools.js"></script>
        <script type="text/javascript" src="js/user/editInformation.js"></script>
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
                    <form action="editInformationAction" method="post">
                        <table>
                            <tr>
                                <td>真实姓名：</td>
                                <td><input type="text" name="realName" value="${user.realName }"/></td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td>
                                <c:if test="${user.sex == 0 }">
                                男<input type="radio" name="sex" value="0" checked="checked" /> 
                                女<input type="radio" name="sex" value="1" /><br />
                                </c:if>
                                <c:if test="${user.sex == 1 }">
                                男<input type="radio" name="sex" value="0" /> 
                                女<input type="radio" name="sex" value="1" checked="checked" /><br />
                                </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td>选择学校：</td>
                                <td>
                                    <select id="locationSelect" >
                                        <option value="null">请选择</option>
                                    </select>
                                    <select id="schoolSelect" name="schoolId">
                                        <option value="null">请选择</option>
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>选择地区：</td>
                                <td>
                                    <select id="provinceSelect" name="provinceId">
                                        <option value="-1">请选择</option>
                                    </select>
                                    <select id="citySelect" name="cityId">
                                        <option value="-1">请选择</option>
                                    </select>
                                    <select id="areaSelect" name="areaId">
                                        <option value="-1">请选择</option>
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <td><input type="submit" value="修改" /></td>
                                <td><input type="reset" value="重置" /></td>
                            </tr>
                        </table>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>