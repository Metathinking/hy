'use strict';
var app = angular.module("app", ['angularFileUpload']);

app.filter('userStatus', function() { 
    var status=[
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

app.service("paginationService", function () {
    var showPageCount = 9;
    var middlePage = parseInt(showPageCount / 2 + 1);
    var frontPageCount = parseInt(showPageCount / 2);
    this.getStart = function (_index, _pageCount) {
        if (_pageCount < showPageCount) {
            return 0;
        }
        if (_index < middlePage) {
            return 0;
        }
        if (_index + frontPageCount >= _pageCount) {
            return _pageCount - showPageCount;
        }
        return _index - middlePage;
    };
    this.getEnd = function (_index, _pageCount) {
        if (_pageCount < showPageCount) {
            return _pageCount;
        }
        if (_index < middlePage) {
            return showPageCount;
        }
        return _index + frontPageCount;
    };
});
app.directive("homePaginationDirective", function () {
    return {
        restrict: 'A',
        replace: true,
        scope: {
            pageList: '=',
            link: '@',
            index: '=',
            pageCount: '='
        },
        templateUrl: context + '/resources/html/home-pagination.html',
        controller: ['$scope', 'paginationService', function ($scope, paginationService) {
            $scope.getStart = function (_index, _pageCount) {
                return paginationService.getStart(_index, _pageCount);
            }
            $scope.getEnd = function (_index, _pageCount) {
                return paginationService.getEnd(_index, _pageCount);
            }

        }]
    }
})
app.directive("frontPaginationDirective", function () {
    return {
        restrict: 'A',
        replace: true,
        scope: {
            pageList: '=',
            link: '@',
            index: '=',
            pageCount: '='
        },
        templateUrl: context + '/resources/html/front-pagination.html',
        controller: ['$scope', 'paginationService', function ($scope, paginationService) {
            $scope.getStart = function (_index, _pageCount) {
                return paginationService.getStart(_index, _pageCount);
            }
            $scope.getEnd = function (_index, _pageCount) {
                return paginationService.getEnd(_index, _pageCount);
            }

        }]
    }
})
app.directive("adminPaginationDirective", function () {
    return {
        restrict: 'A',
        replace: true,
        scope: {
            pageList: '=',//对象绑定
            initList: '=',//对象绑定
            index: '=',//存储于index相关的字符串
            pageCount: '='
        },

        templateUrl: context + '/resources/html/admin-pagination.html',
        controller: ['$scope', 'paginationService', function ($scope, paginationService) {
            $scope.getStart = function (_index, _pageCount) {
                return paginationService.getStart(_index, _pageCount);
            }
            $scope.getEnd = function (_index, _pageCount) {
                return paginationService.getEnd(_index, _pageCount);
            }

        }]
    }
})
