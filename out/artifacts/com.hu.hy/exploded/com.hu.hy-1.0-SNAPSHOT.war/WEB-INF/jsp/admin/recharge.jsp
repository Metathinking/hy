<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/17.0017
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/angular-1.5.0.min.js"></script>
</head>
<body ng-app="app" ng-controller="rechargeController">
用户编号：${user.id}，用户名：${user.uname} 现在充值
<br/>
充值金额:<input type="number" ng-model="record.money"/>
<br/>
备注信息：<input type="text" ng-model="record.remark"/>
<br/>
<button ng-click="recharge()">充值</button>
</body>
</html>
<script>
    angular.module("app",[])
            .controller("rechargeController",function($scope,$http){
                $scope.record={
                    userId:"${user.id}",
                    money:0,
                    remark:""
                };
                $scope.recharge=function(){
                    var request={
                        method:"POST",
                        url: '/recharge/recharge',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        data: $scope.record
                    };
                    $http(request).success(function (response, status, headers, cfg) {
                        alert(response.msg);
                    }).error(function (response, status, headers, cfg) {
                        $scope.error = "充值失败";
                    })
                };

            });
</script>
