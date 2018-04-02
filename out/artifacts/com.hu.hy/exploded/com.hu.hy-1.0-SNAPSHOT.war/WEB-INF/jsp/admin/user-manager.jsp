<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/17.0017
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i>用户管理</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="/manager/home">首页</a></li>
            <li><i class="fa fa-table"></i>用户管理</li>
        </ol>
    </div>
</div>
<div ng-controller="userManagerController">
<table class="table table-hover" ng-init="initList(index)">
    <tr>
        <td>编号</td>
        <td>用户号</td>
        <td>昵称</td>
        <td>头像</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <tr ng-repeat="item in list">
        <td>{{item.id}}</td>
        <td>{{item.uid}}</td>
        <td>{{item.uname}}</td>
        <td><img ng-src="/resources/portrait/{{item.portrait}}"
                 style="width: 50px;height: 50px;"/></td>
        <td>{{item.status}}</td>
        <td>
            <a class="btn btn-primary btn-sm" href="/recharge/gotoRecharge/{{item.id}}">充值</a>
            <div ng-if="item.status=='WAIT'">
                <button ng-click="verify(item.id,true,$index)">审核通过</button>
                <button ng-click="verify(item.id,false,$index)">审核不通过</button>
            </div>
            <div ng-if="item.status=='SHOW' || item.status=='HIDE'">
                <button ng-click="cancel(item.id,$index)">屏蔽</button>
            </div>
        </td>
    </tr>
</table>
    <div admin-pagination-directive page-list="pageList" init-list="initList" page-count="pageQuery.pageCount"
         index="index"></div>
</div>
<script>
            app.controller("userManagerController", function ($scope, $http) {
                $scope.index = 1;
                //获取列表数据 start
                $scope.initList = function (index) {
                    $scope.index = index;
                    var data = {
                        index: $scope.index,
//                        platform:$scope.platform,
//                        searchType:$scope.searchType,
//                        name:$scope.name,
//                        orders:orders
                    };
                    var request = {
                        method: 'POST',
                        url: '/admin/userManager/list',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: data
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        if (response.success) {
                            $scope.error = "";
                            $scope.list = response.data.list;
                            $scope.pageQuery = response.data.pageQuery;
                            $scope.pageList = [];
                            for (var i = 1; i < $scope.pageQuery.pageCount + 1; i++) {
                                $scope.pageList.push(i);
                            }
                        } else {
                            $scope.error = response.msg;
                        }

                    }).error(function (response, status, headers, cfg) {
                        $scope.error = "请求失败";
                    })
                };
                //获取列表数据 end

                $scope.verify = function (id, pass, index) {
                    var url= '/admin/userManager/verify/' + id + "/" + pass;
                   $scope.changeStatus(url,index);
                };
                $scope.cancel=function(id,index){
                    var url= '/admin/userManager/cancel/' + id;
                    $scope.changeStatus(url,index);
                };
                $scope.changeStatus=function(url,index){
                    var request = {
                        method: "POST",
                        url: url
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        $scope.list[index].status = response.data;
                    }).error(function (response, status, headers, cfg) {
                        $scope.error = "请求失败";
                    })
                }
            })
</script>
