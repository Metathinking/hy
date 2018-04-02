app.service('adminLoginLogService',function($http){
    this.initList = function(_index){
        var req = {
            method: 'POST',
            url: '/admin/managerLoginLog/list',
            headers: {
                'Content-Type': 'application/json'
            },
            data: {
                index:_index
            }
        }
        return $http(req);
    }
})