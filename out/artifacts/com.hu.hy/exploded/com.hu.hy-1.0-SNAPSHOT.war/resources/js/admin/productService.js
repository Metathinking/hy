app.service("productService", function ($http) {
    this.initList = function (_data) {
        var req = {
            method: 'POST',
            url: context + '/admin/product/list',
            headers: {
                'Content-Type': 'application/json'
            },
            data: _data
        };
        return $http(req);
    };
    this.deleteOverDue = function () {
        var req = {
            method: 'POST',
            url: context + '/admin/product/deleteOverDue',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        return $http(req);
    };
    this.delete = function (_id) {
        var req = {
            method: 'POST',
            url: context + '/admin/product/delete?id=' + _id,
            headers: {
                'Content-Type': 'application/json'
            }
        };
        return $http(req);
    };
    this.deleteDuplicate = function () {
        var req = {
            method: 'POST',
            url: context + '/admin/product/deleteDuplicate',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        return $http(req);
    };
    
})