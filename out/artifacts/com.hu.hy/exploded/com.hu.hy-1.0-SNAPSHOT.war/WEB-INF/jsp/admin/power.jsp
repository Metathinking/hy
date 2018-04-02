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
            <li><i class="fa fa-table"></i>管理员：${manager.name}</li>
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
                <td>权限</td>
                <td>开启</td>
            </tr>
            <tr ng-repeat="item in list">
                <td>{{item.id}}</td>
                <td>{{item.description}}</td>
                <td>
                    <input type="checkbox"  ng-model="item.open" class="checkbox"/>
                </td>
            </tr>
        </table>
    </div>

    <div class="row">
        <div class="col-md-4 col-md-offset-2">
            <button class="btn btn-raised btn-primary" ng-click="save()">保存</button>
        </div>
    </div>
</div>
<script>
    app.controller("adminManagerController",function($scope,$http){

        $scope.save=function(){
            var request = {
                method: 'POST',
                url:   '/admin/power/edit',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: $scope.list
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
                url:  '/admin/power/list/${manager.id}',
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
    });
</script>