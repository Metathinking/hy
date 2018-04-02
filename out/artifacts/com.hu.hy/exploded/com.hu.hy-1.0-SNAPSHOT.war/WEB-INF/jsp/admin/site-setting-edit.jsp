<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2016/6/15.0015
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i>网站设置</h3>
        <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="/manager/home">首页</a></li>
            <li><i class="fa fa-table"></i>网站设置</li>
        </ol>
    </div>
</div>

<div ng-controller="siteSettingController" ng-init="find()" >
    <div class="" style="margin-bottom: 12px">
        <div class="row form-group form-horizontal">
            <div class="col-md-2">
                <label class="control-label pull-right" for="registerDou">
                    注册赠送推广豆
                </label>
            </div>
            <div class="col-md-4">
                <input id="registerDou" type="text" ng-model="siteSetting.registerDou"  class="form-control">
            </div>
            <div class="col-md-4">
                <div class="control-label pull-left">不能小于0</div>
            </div>
        </div>
        <div class="row form-group form-horizontal">
            <div class="col-md-2">
                <label class="control-label pull-right" for="signInStart">
                    第一天签到赠送推广豆
                </label>
            </div>
            <div class="col-md-4">
                <input id="signInStart" type="text" ng-model="siteSetting.signInStart"  class="form-control">
            </div>
            <div class="col-md-4">
                <div class="control-label pull-left">不能小于0</div>
            </div>
        </div>
        <div class="row form-group form-horizontal">
            <div class="col-md-2">
                <label class="control-label pull-right" for="signInEnd">
                    签到赠送推广豆上限
                </label>
            </div>
            <div class="col-md-4">
                <input id="signInEnd" type="text" ng-model="siteSetting.signInEnd"  class="form-control">
            </div>
            <div class="col-md-4">
                <div class="control-label pull-left">不能小于第一天的数量</div>
            </div>
        </div>
        <div class="row form-group form-horizontal">
            <div class="col-md-2">
                <label class="control-label pull-right" for="signInStep">
                    连续签到增加推广豆数量
                </label>
            </div>
            <div class="col-md-4">
                <input id="signInStep" type="text" ng-model="siteSetting.signInStep"  class="form-control">
            </div>
            <div class="col-md-4">
                <div class="control-label pull-left ">不能小于0</div>
            </div>
        </div>
        <div class="row form-group form-horizontal">
            <div class="col-md-2">
                <label class="control-label pull-right">
                    上次更新时间
                </label>
            </div>
            <div class="col-md-4">
                <div class="control-label pull-left" ng-bind="siteSetting.time|date:'yyyy-MM-dd HH:mm:ss'"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <button class="btn btn-raised btn-primary" ng-click="save()">保存</button>
            </div>
        </div>
        <div class="alert alert-danger" ng-if="error">
            <div ng-bind="error"></div>
        </div>
        <div class="alert alert-info" ng-if="info">
            <div ng-bind="info"></div>
        </div>
    </div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/siteSettingService.js"></script>
<script>
    app.controller('siteSettingController',function($scope,siteSettingService){
        //获取 网站设置信息 start
        $scope.find = function(){
            siteSettingService.find()
                    .success(function(response,status,headers,cfg){
                        if(response.success){
                            $scope.siteSetting=response.data;
                            $scope.error="";
                        }else{
                            $scope.error=response.msg;
                        }
                    }).error(function(response,status,headers,cfg){})
        }
        //获取网站设置信息 end

        //保存 start
        $scope.save = function(){
            siteSettingService.save($scope.siteSetting)
                    .success(function(response,status,headers,cfg){
                        if(response.success){
                            $scope.siteSetting=response.data;
                            $scope.error="";
                        }else{
                            $scope.error=response.msg;
                        }
                    }).error(function(response,status,headers,cfg){})
        }
        //保存 end
    })
</script>
