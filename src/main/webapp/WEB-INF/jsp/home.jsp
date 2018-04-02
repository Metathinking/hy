<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/1/16.0016
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="baidu-site-verification" content="YmnCpEh7KA"/>
    <meta name="keywords" content="${siteInfo.keywords}"/>
    <meta name="description" content="${siteInfo.description}"/>
    <title>${siteInfo.name}</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <%--<link rel="stylesheet" href="/resources/css/font-awesome.min.css"/>--%>
    <%--<link rel="stylesheet" href="/resources/css/prettyPhoto.css"/>--%>
    <%--<link rel="stylesheet" href="/resources/css/main.css"/>--%>
    <%--<link rel="stylesheet" href="/resources/css/main.css"/>--%>
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/angular-1.5.0.min.js"></script>
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <style>
        body {
            padding-top: 70px; /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        .portfolio-item {
            margin-bottom: 25px;
        }
        footer {
            margin: 50px 0;
        }
    </style>
</head>
<body ng-app="app" ng-controller="mainController" data-spy="scroll" data-target="#navbar" data-offset="0">
<%--<body ng-app="app" ng-controller="mainController">--%>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 ">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">${siteInfo.name}</a>
                </div>
            </div>
            <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 ">
                <form class="navbar-form navbar-right" role="search">
                    <input type="text" class="form-control" placeholder="Search">
                    <button class="btn btn-warning" type="button" ng-click="search()">搜索</button>
                    <c:if test="${USER==null}">
                        <a href="/to_login/weixin" style="margin-left: 50px">登录</a>
                    </c:if>
                    <c:if test="${USER!=null}">
                        <a href="/uc/${USER.openid}" style="margin-left: 50px">${USER.nickname}</a>
                        <a href="/logout">退出</a>
                    </c:if>

                </form>
            </div>
        </div>
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">
    <!-- Page Header -->
    <%--<div class="row">--%>
        <%--<div class="col-lg-12">--%>
            <%--<h1 class="page-header">Page Heading--%>
                <%--<small>Secondary Text</small>--%>
            <%--</h1>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!-- /.row -->

    <!-- Projects Row -->
    <div class="row">
        <c:forEach items="${list}" var="item">
            <div class="col-md-4 col-lg-3 col-sm-6 col-xs-6 portfolio-item person" style="border:solid 1px;">
                <div class="" style="border: dotted 1px;width:auto">
                    <a href="/get/${item.openid}">
                        <img src="${item.headimgurl}"  style="width:150px"/>
                            <%--<p><label class="label label-info">性感</label><label class="label label-info">美女</label><label class="label label-info">滨州</label></p>--%>
                        <p><b >性感</b><b >美女</b><b>滨州</b></p>
                        <p class="address">山东滨州</p>
                        <p>${item.nickname} <span class="pull-right">女</span></p>
                    </a>
                </div>

                <%--<a href="#">--%>
                    <%--<img src="/resources/portrait/${item.portrait}"/>--%>
                        <%--&lt;%&ndash;<img class="img-responsive" src="http://placehold.it/700x400" alt="">&ndash;%&gt;--%>
                <%--</a>--%>
                <%--<h3>--%>
                    <%--<a href="/get/${item.id}">${item.uname}</a>--%>
                <%--</h3>--%>
                <%--<p>${item.uid}</p>--%>
            </div>
        </c:forEach>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Pagination -->
    <c:if test="${list.size()!=0}">
        <div class="row text-center">
            <div class="col-lg-12">
                <ul class="pagination">
                    <li class="${pageQuery.index==1?'disabled':''}">
                        <a href="javascript:void(0)" aria-label="Previous" ng-click="gotoPage(1)">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="${pageQuery.index==1?'disabled':''}">
                        <a href="javascript:void(0)" aria-label="Previous" ng-click="prePage()">
                            <span aria-hidden="true">上一页</span>
                        </a>
                    </li>
                    <c:forEach begin="${pageQuery.startPage}" end="${pageQuery.endPage}" var="index">
                        <li class="${index==pageQuery.index?'active':''}"><a href="javascript:void(0)" ng-click="gotoPage('${index}')">${index}</a> </li>
                    </c:forEach>
                    <li class="${pageQuery.index==pageQuery.pageCount?'disabled':''}">
                        <a href="javascript:void(0)" aria-label="Next" ng-click="nextPage()">
                            <span aria-hidden="true">下一页</span>
                        </a>
                    </li>
                    <li class="${pageQuery.index==pageQuery.pageCount?'disabled':''}">
                        <a href="javascript:void(0)" aria-label="Next" ng-click="gotoPage('${pageQuery.pageCount}')">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li class="disabled">
                        <span>共${pageQuery.pageCount}页，${pageQuery.count}条</span>
                    </li>
                </ul>
            </div>
        </div>
    </c:if>
    <!-- /.row -->
    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>${siteInfo.footer}</p>
            </div>
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->

<!--edit modal start-->
<div class="modal fade" id="tipModal" tabindex="-1" role="dialog" aria-labelledby="tipLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="tipLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body">
                继续查看，您可能会消耗推广豆
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" ng-click="jixu()">继续</button>
            </div>
        </div>
    </div>
</div>
<!--edit modal end-->
</body>
</html>
<script>
    angular.module("app", [])
            .controller("mainController", function ($scope, $http) {
                $scope.select=function(item){
                    $scope.selectSearchType=item;
                };
                $scope.search=function () {
                    $scope.gotoPage(1);
                };
                $scope.prePage=function () {
                    if(${pageQuery.index==1}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index-1>0?pageQuery.index-1:1})
                };
                $scope.nextPage=function () {
                    if(${pageQuery.index==pageQuery.pageCount}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index+1<pageQuery.pageCount?pageQuery.index+1:pageQuery.pageCount})
                }
                $scope.gotoPage=function(index){
                    window.location.href="/home?searchType="+$scope.selectSearchType.value+"&name="+$scope.searchName+"&index="+index;
                }
            });
</script>

