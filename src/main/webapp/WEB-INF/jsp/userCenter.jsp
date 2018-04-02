<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/15.0015
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${siteInfo.name}-用户中心</title>
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
                        <a href="/to_login/baidu" style="margin-left: 50px">登录</a>
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
<div id="content">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-sm-3 col-lg-3">
                <div class="account-container">
                    <div class="account-avatar">
                        <%--<img src="{{user.headimgurl}}" alt="" class="thumbnail">--%>
                        <img ng-src="{{user.headimgurl}}" class="thumbnail"/>
                    </div> <!-- /account-avatar -->
                    <div class="account-details">
                        <span class="account-name"><span ng-bind="user.nickname"></span></span>
                            <span ng-if="user.weixinNo" class="account-role">
                               微信号： <b ng-bind="user.weixinNo"></b>
                            </span>
                            <span ng-if="!user.weixinNo">
                                <input type="text" ng-model="weixinNo" placeholder="请添加微信号"/><button
                                    class="btn btn-info btn-xs" ng-click="addNo()">添加</button>
                            </span>
                        <b ng-bind="user.weixinNo?user.weixinNo:'未填写'"></b>
                        <span class="account-role">状态：<b ng-bind="user.status|userStatus"></b></span>
                        <div ng-if="user.status=='SHOW'">
                            <button ng-click="hide()" class="btn btn-warning btn-xs">隐身</button>
                        </div>
                        <div ng-if="user.status=='HIDE'">
                            <button ng-click="show()" class="btn btn-warning btn-xs">显示</button>
                        </div>
                        <div ng-if="user.status=='NO_PASS'">
                            <button ng-click="apply()" class="btn btn-warning btn-xs">申请审核</button>
                        </div>
                        <div ng-if="user.status=='CANCEL'">
                            <button ng-click="apply()" class="btn btn-warning btn-xs">申请审核</button>
                        </div>
                        <br/>
						<span class="account-actions">
                            <div ng-if="hasSignIn">
                                <button class="btn btn-default btn-xs disabled">已签到</button>
                            </div>
                            <div ng-if="!hasSignIn">
							<button class="btn btn-warning btn-xs" ng-click="signIn()">签到</button><small class="">赠送推广豆</small>
                            </div>

						</span>
                    </div> <!-- /account-details -->
                </div> <!-- /account-container -->
                <hr>
                <ul id="main-nav" class="nav nav-tabs nav-stacked">
                    <li>
                        <span class="glyphicon glyphicon-tint pull-right"></span>推广豆：<span ng-bind="userInfo.bean"></span>
                    </li>
                    <li>
                        <span class="glyphicon glyphicon-book pull-right"></span>积分：<span ng-bind="userInfo.jifen"></span>
                    </li>
                    <li>
                        <span class="glyphicon glyphicon-globe pull-right"></span>推广人数：<span ng-bind="userInfo.extendCount"></span>
                    </li>
                </ul>
                <hr/>
                免豆查看设置：<br/>
                状态:<b ng-bind="freeBeanSetting.open|freeBeanFilter"></b><br/>
                <div ng-if="freeBeanSetting.open">

                    剩余数量：<span ng-bind="freeBeanSetting.count"></span><br/>
                    初始数量:<span ng-bind="freeBeanSetting.startCount"></span><br/>
                    <button class="btn btn-warning btn-xs" data-toggle="modal" data-target="#tipModal">关闭</button>
                </div>
                <div ng-if="!freeBeanSetting.open">
                    <button class="btn btn-warning btn-xs" data-toggle="modal" data-target="#tipModal">开启</button>
                </div>
                <hr/>
                <div>
                    <button  data-toggle="modal" data-target="#editModal">编辑</button>
                </div>
                <div class="sidebar-extra">
                    标签：<label><b ng-bind="user.label"></b></label>
                </div>
                <div class="sidebar-extra">
                    <p><b ng-bind="user.introduction"></b></p>
                </div> <!-- .sidebar-extra -->
                <br>
            </div> <!-- /span3 -->
            <div class="col-xs-12 col-sm-12 col-sm-9 col-lg-9">
                <h1 class="page-title">
                    <span class="glyphicon glyphicon-eye-open"></span>查看记录
                </h1>
                <div class="row">
                </div>
            </div>
        </div> <!-- /row -->
    </div> <!-- /container -->
</div> <!-- /content -->
<!--edit modal start-->
<div class="modal fade" id="tipModal" tabindex="-1" role="dialog" aria-labelledby="tipLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="tipLabel">
                     <span ng-if="freeBeanSetting.open">
                        关闭
                    </span>
                    <span ng-if="!freeBeanSetting.open">
                        开启
                    </span>
                </h4>
            </div>
            <div class="modal-body">
                <div ng-if="freeBeanSetting.open">
                    您要关闭免推广豆查看设置么？
                </div>
                <div ng-if="!freeBeanSetting.open">
                    您最高可设置免推广豆查看数量为：<span ng-bind="userInfo.bean"></span><br/>
                    <input type="number" ng-model="bean.setCount">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="change()">保存</button>
            </div>
        </div>
    </div>
</div>
<!--edit modal end-->

<!--编辑信息 modal start-->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="tipLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editLabel">
                  编辑
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>微信号</label>
                    <input type="text" class="form-control" ng-model="user.weixinNo">
                </div>
                <div class="form-group">
                    <label>标签</label>（添加Tag，你的内容能被更多人看到,请用空格“ ”作为分隔符，例如：互联网 华为 任正非）
                    <input type="text" class="form-control" ng-model="user.label"/>
                </div>
                <div class="form-group">
                    <label>简介</label>
                    <textarea style="width: 100%;height: 100px" ng-model="user.introduction"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="editMsg()">更改</button>
            </div>
        </div>
    </div>
</div>
<!--编辑 modal end-->
</body>
</html>
<script>
  var app=  angular.module("app",[]);
  app.filter('userStatus', function() {
      var status=[
          {name:"INIT",description:"未申请审核"},
          {name:"WAIT",description:"待审核"},
          {name:"NO_PASS",description:"审核未通过"},
          {name:"SHOW",description:"显示"},
          {name:"HIDE",description:"隐身"},
          {name:"CANCEL",description:"屏蔽"}
      ];
      return function(text) {
          for(var i=0;i<status.length;i++){
              if(status[i].name==text){
                  return status[i].description;
              }
          }
          return "";
      }
  });
  app.filter("freeBeanFilter",function () {
      var status=[
          {name:true,description:"开启"},
          {name:false,description:"关闭"}
      ];
      return function(text) {
          for(var i=0;i<status.length;i++){
              if(status[i].name==text){
                  return status[i].description;
              }
          }
          return "";
      }
  });
            app.controller("userController",function($scope,$http){
                $scope.user={
                   openid:"${userBO.user.openid}",
                    weixinNo:"${userBO.user.weixinNo}",
                    nickname:"${userBO.user.nickname}",
                    headimgurl:"${userBO.user.headimgurl}",
                    status:"${userBO.user.status}",
                    codeUrl:"${userBO.user.codeUrl}",
                    label:"${userBO.user.label}",
                    introduction:"${userBO.user.introduction}"
                };
                $scope.hasSignIn=${userBO.hasSignIn};
                $scope.userInfo={
                    bean:${userBO.userInfo.bean},
                    "jifen":${userBO.userInfo.jifen},
                    "extendCount":${userBO.userInfo.extendCount}
                };
                $scope.freeBeanSetting={
                    open:${userBO.freeBeanSetting.open},
                    count:${userBO.freeBeanSetting.count},
                    startCount:${userBO.freeBeanSetting.startCount}
                };
                $scope.error="";
                $scope.bean={
                    setCount:0
                };
                $scope.addNo=function(){
                    var request={
                        method:"POST",
                        url:""
                    }
                }
                $scope.signIn = function () {
                    var request={
                        method:"POST",
                        url:"/signIn/${userBO.user.openid}"
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        $scope.hasSignIn=response.success;
                        if(response.success){
                            $scope.error="";
                            $scope.userInfo=response.data;
                        }else{
                            $scope.error="签到失败:"+response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                        $scope.error="签到失败:"+response;
                    });
                };
                //隐身
                $scope.hide=function(){
                    var url= "/hide/"+$scope.user.id;
                    $scope.changeStatus(url);
                };
                //显示
                $scope.show=function(){
                    var url="/show/"+$scope.user.id;
                   $scope.changeStatus(url);
                };
                //申请审核
                $scope.apply=function(){
                    var url="/apply/"+$scope.user.id;
                    $scope.changeStatus(url);
                };

                $scope.changeStatus=function (url) {
                    var request={
                        method:"POST",
                        url:url
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        if(response.success){
                            $scope.error="";
                            $scope.user.status=response.data.status;
                        }else{
                            $scope.error="操作失败:"+response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                        $scope.error="操作失败:"+response;
                    });
                };

                //更新免豆查看设置
                $scope.change=function(){
                    var request={
                        method:"POST",
                        url:"/freeBean/change?count="+$scope.bean.setCount+"&open="+!$scope.freeBeanSetting.open
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        $scope.bean.setCount=0;
                        if(response.success){
                            $scope.error="";
                            $scope.freeBeanSetting=response.data.freeBeanSetting;
                            $scope.userInfo=response.data.userInfo;
                        }else{
                            $scope.error="操作失败:"+response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                        $scope.error="操作失败:"+response;
                    });
                }
                //更新用户可编辑的信息（微信号,二维码，标签，简介）
                $scope.editMsg=function(){
                    var request={
                        method:"POST",
                        url:"/uc/editMsg",
                        data:$scope.user
                    };
                    $http(request).success(function(response,status,headers,cfg){
                        if(response.success){
                            $scope.error="";
                            $scope.user.weixinNo=response.data.weixinNo;
                            $scope.user.codeUrl=response.data.codeUrl;
                            $scope.user.label=response.data.label;
                            $scope.user.introduction=response.data.introduction;

                        }else{
                            $scope.error="保存失败："+response.msg;
                        }
                    }).error(function(response,status,headers,cfg){
                        $scope.error="保存失败:"+response;
                    })
                }
            });
</script>
