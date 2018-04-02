<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="keywords" content="${keywords==null?siteInfo.keywords:keywords}"/>
    <meta name="description" content="${description==null?siteInfo.description:description}"/>
    <title>${title==null?siteInfo.name:title}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/roboto.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design-mine.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ripples.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular-1.5.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Utils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/material.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ripples.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular-file-upload.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/md5.js"></script>
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <script>
        var context = "${context}";
    </script>
</head>
<body ng-app="app" class="container-fluid">
<div ng-controller="adminLoginController">
    <div class="passport-wrapper ">
        <div class="text-center" style="margin-bottom: 12px">
            <a href="${pageContext.request.contextPath}/">
                <img class="head-logo" src="${pageContext.request.contextPath}/resources/images/logo.jpg"/>
            </a>
        </div>
        <div class="passport-sign">
            <div class="row">
                <h3 class="heading-desc text-center" style="display:block">登录</h3>
            </div>
            <div class="main">
                <div class="form-group  label-floating login-form-group">
                    <label for="name" class="control-label">账号</label>
                    <input type="text" class="form-control" id="name" ng-model="user.name" autofocus>
                </div>
                <div class="form-group label-floating login-form-group">
                    <label for="password" class="control-label">密码</label>
                    <input type="password" class="form-control" id="password" ng-model="user.password">
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="form-group label-floating login-form-group">
                            <label for="code" class="control-label">验证码</label>
                            <input type="text" class="form-control" id="code" ng-model="user.code" ng-keypress="($event.which === 13)?login():0">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <!--验证码 start-->
                        <img onClick="this.src=this.src+'?t='+Math.random()" id="imVcode" title="点击换一个校验码"
                             src="${pageContext.request.contextPath}/code" style="margin-top: 6px">
                        <!--验证码 end-->
                    </div>
                </div>
                <div class="tip">
                    <div class="alert alert-danger" ng-if="error">
                        <div ng-bind="error"></div>
                    </div>
                </div>

                <button class="btn btn-raised btn-primary btn-lg btn-block" ng-click="login()" ng-show="!loading">
                    登录
                </button>
                <button type="button" class="btn btn-raised btn-primary btn-lg btn-block" ng-if="loading">
                    <i class="fa fa-refresh fa-spin"></i>登录中
                </button>
            </div>
            <span class="clearfix"></span>
        </div>
    </div>
</div>
</body>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/js/admin/adminLoginService.js"></script>
<script>
    app.controller("adminLoginController", function ($scope, adminLoginService) {
        $scope.user = {
            name: '',
            password: '',
            code: ''
        }
        $scope.loading = false;
        $scope.login = function () {
            if ($scope.user.name.length == 0) {
                $scope.error = "请入账号";
                return;
            }
            if ($scope.user.password.length == 0) {
                $scope.error = "请输入密码";
                return;
            }
            if ($scope.user.code.length == 0) {
                $scope.error = "请输入验证码";
                return;
            }
            $scope.loading = true;
            var data = {
                name: $scope.user.name,
                password: hex_md5($scope.user.password),
                code: $scope.user.code
            }
            adminLoginService.login(data).success(function (response, status, headers, cfg) {
                $scope.loading = false;
                if (response.success) {
                    $scope.error = "";
                    window.location.href = "${pageContext.request.contextPath}/admin/home";
                } else {
                    $scope.error = response.msg;
                }
            }).error(function (response, status, headers, cfg) {
                $scope.loading = false;
                $scope.error = response;
            })
        }
    })
</script>

