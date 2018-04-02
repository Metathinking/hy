<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/19.0019
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${siteInfo.name}-${aUser.nickname}</title>
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/angular-1.5.0.min.js"></script>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <link href="/resources/css/adminia.css" rel="stylesheet">
    <link href="/resources/css/adminia-responsive.css" rel="stylesheet">
    <link href="/resources/css/dashboard.css" rel="stylesheet">
</head>
<body ng-app="app" ng-controller="userController">

<div id="content">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-sm-3 col-lg-3">
                <div class="account-container">
                    <div class="account-avatar">
                        <img src="/resources/portrait/${aUser.headimgurl}" style="height: 80px;width: 80px;"/>
                    </div> <!-- /account-avatar -->
                    <div class="account-details">
                        <span class="account-name"><span >${aUser.nickname}</span></span>
                        <span class="account-role">微信号：<b>${aUser.weixinNo}</b></span>
                        <span class="account-role">状态：<b ng-bind="user.status|userStatus"></b></span>
                    </div> <!-- /account-details -->
                </div> <!-- /account-container -->
                <hr>

                <div class="sidebar-extra">
                    标签：<label>${aUser.label}</label>
                </div>
                <div class="sidebar-extra">
                    <p>${aUser.introduction}</p>
                </div> <!-- .sidebar-extra -->
                <br>
            </div> <!-- /span3 -->
            <div class="col-xs-12 col-sm-12 col-sm-9 col-lg-9">
                <img src="/resources/portrait/${aUser.headimgurl}"/>
            </div>
        </div> <!-- /row -->
    </div> <!-- /container -->
</div> <!-- /content -->

</body>
</html>

<%--被查看人的信息:<br/>--%>
<%--id:${aUser.id}<br/>--%>
<%--uid:${aUser.uid}<br/>--%>
<%--uname:${aUser.uname}<br/>--%>
<%--portrait:<img src="/resources/portrait/${aUser.portrait}"/><br/>--%>
