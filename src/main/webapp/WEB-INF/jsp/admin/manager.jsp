<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/24.0024
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i>权限管理</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="/manager/home">首页</a></li>
            <li><i class="fa fa-table"></i>管理员</li>
        </ol>
    </div>
</div>
<div ng-controller="adminManagerController">
    <div class="table-bg">
        <div class="alert alert-danger" ng-if="error">
            {{error}}
        </div>
        <table class="table table-striped table-hover" ng-init="initList()">
            <tr>
                <td>序号</td>
                <td>用户名</td>
                <td>操作</td>
            </tr>
            <tr ng-repeat="item in list">
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>
                    <button class="btn btn-primary" ng-click="select(item,$index)">编辑</button>
                    <button class="btn btn-default" ng-click="delete(item.id,$index)">删除</button>
                    <a class="btn btn-success" href="/admin/power/list/{{item.id}}">权限</a>
                </td>
            </tr>
        </table>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-table"></i>管理员信息编辑</h3>
        </div>
    </div>
    <div class="row form-group form-horizontal">
        <div class="col-md-2">
            <label class="control-label pull-right" for="name">
                管理员名称
            </label>
        </div>
        <div class="col-md-8">
            <input id="name" type="text" ng-model="manager.name"  class="form-control">
        </div>
    </div>
    <div class="row form-group form-horizontal">
        <div class="col-md-2">
            <label class="control-label pull-right" for="password">
                管理员密码
            </label>
        </div>
        <div class="col-md-8">
            <input id="password" type="text" ng-model="manager.password"  class="form-control">
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <button class="btn btn-raised btn-primary" ng-click="save()">保存</button>
        </div>
    </div>
</div>
<script>
    app.controller("adminManagerController",function($scope,$http){
        var initAdmin={name:"",password:""};
        $scope.manager=angular.copy(initAdmin);
        $scope.select=function(manager,index){
            $scope.manager=angular.copy(manager);
            $scope.index=index;
        };
        $scope.save=function(){
            var request = {
                method: 'POST',
                url:   '/admin/manager/edit',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: $scope.manager
            };
            $http(request).success(function (response, status, headers, cfg) {
                if(response.success){
                    $scope.error="";
                    $scope.manager=angular.copy(initAdmin);
                    $scope.initList();
                }else{
                    $scope.error=response.msg;
                }

            }).error(function (response, status, headers, cfg) {
                $scope.error = "请求失败";
            })
        };
        $scope.initList=function(){
            var request = {
                method: 'POST',
                url:  '/admin/manager/list',
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            $http(request).success(function (response, status, headers, cfg) {
                if(response.success){
                    $scope.error="";
                    $scope.list= response.data;
                }else{
                    $scope.error=response.msg;
                }

            }).error(function (response, status, headers, cfg) {
                $scope.error = "请求失败";
            })
        };
        $scope.delete=function(id,index){
            var request = {
                method: 'POST',
                url:  '/admin/manager/delete/'+id,
                headers: {
                    'Content-Type': 'application/json'
                }
            };
            $http(request).success(function (response, status, headers, cfg) {
                if(response.success){
                    $scope.error="";
                    $scope.list.splice(index,1);
                }else{
                    $scope.error=response.msg;
                }

            }).error(function (response, status, headers, cfg) {
                $scope.error = "删除失败";
            })
        }
    });
</script>