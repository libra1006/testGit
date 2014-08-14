<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
    
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
        <script type="text/javascript" src="js/tools.js"></script>
        <script type="text/javascript" src="js/user/baseInformation.js"></script>
        
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <link href="css/global.css" rel="stylesheet">
    
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>" />
    	<title>修改资料</title>
    </head>
    <body>
        <!-- 隐藏数据域 -->
        <input type="hidden" id="schoolIdValue" value="${user.school == null ? '-1' : user.school.id }"/> 
        <input type="hidden" id="locationIdValue" value="${user.location == null ? '-1' : user.location.id }"/> 
        <input type="hidden" id="sexValue" value="${user.sex }"/> 
        
        
        <div class="container  frame">
            <div class="row">
                <div class="col-xs-3 col-xs-offset-9">
                    <ol class="breadcrumb">
                      <li><a href="#">Home</a></li>
                      <li><a href="#">Library</a></li>
                      <li class="active">Data</li>
                    </ol>
                </div>
            </div>
        
            <div class="row">
                <div class="col-xs-3" id="menuPanel">
                    <ul class="nav nav-tabs nav-stacked">
                        <li>
                            <a href="baseInformation">基本资料</a>
                        </li>
                        <li>
                            <a href="moreInformation">详细资料</a>
                        </li>
                        <li>
                            <a href="baseInformation">设置头像</a>
                        </li>
                        <li>
                            <a href="baseInformation">修改密码</a>
                        </li>
                    </ul>
                </div>
                
                <div class="col-xs-6" id="informationPanel">
                    <form class="form-horizontal" action="baseInformationAction" method="post">
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">真实姓名</label>
                            <div class="col-xs-6">
                                <input class="form-control" type="text" name="realName" value="${user.realName }"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">性别</label>
                            <div class="col-xs-6">
                                <input type="radio" id="sexRadio" name="sex" value="0" />男
                                <input type="radio" id="sexRadio" name="sex" value="1" />女
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-xs-3">学校</label>
                            <div class="col-xs-6">
                                <select class="form-control" id="schoolLocationSelect" >
                                </select>
                                <select class="form-control" id="schoolSelect" name="schoolId">
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-xs-3">地区</label>
                            <div class="col-xs-6">
                                <select class="form-control" id="provinceSelect" name="provinceId">
                                </select>
                                <select class="form-control" id="citySelect" name="cityId">
                                </select>
                                <select class="form-control" id="areaSelect" name="areaId">
                                </select>
                            </div>
                        </div>
                        <table>
                            
                            <tr>
                                <td><input type="submit" value="保存" /></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="userPanel">
            
        </div>
    </body>
</html>