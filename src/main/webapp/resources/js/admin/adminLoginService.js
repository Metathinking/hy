app.service("adminLoginService",function($http){
    this.login = function(_data){
        var req = {
            method: 'POST',
            url:'/adminLogin/login',
            headers: {
                'Content-Type': 'application/json'
            },
            data: _data
        };
        return $http(req);
    }
});
