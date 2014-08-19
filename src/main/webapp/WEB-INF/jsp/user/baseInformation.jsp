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
                <div class="col-xs-12">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle"
                                data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                                <span class="icon-bar"></span> <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="home">Flea School</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            
                            <ul class="nav navbar-nav">
                                <li>
                                    <a href="userCenter">个人中心</a>
                                </li>
                                <li>
                                    <a href="home">交易市场</a>
                                </li>
                            </ul>
                    
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">Link</a></li>
                                <li><a href="#">Link</a></li>
                                <li class="dropdown"><a href="#"
                                    class="dropdown-toggle" data-toggle="dropdown">Dropdown
                                        <b class="caret"></b>
                                </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">One more separated link</a></li>
                                    </ul></li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#">Link</a></li>
                                <li class="dropdown"><a href="#"class="dropdown-toggle" data-toggle="dropdown">Dropdown
                                        <b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul></li>
                            </ul>
                        </div>
                    </nav>
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
                        <div class="form-group">
                            <div class="col-xs-3 col-xs-offset-3">
                                <input class="btn btn-info" type="submit" value="保存" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="userPanel">
            
        </div>
    </body>
</html>