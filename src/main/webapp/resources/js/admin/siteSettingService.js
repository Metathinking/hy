app.service("siteSettingService", function ($http) {
    this.save = function (_data) {
        var req = {
            method: 'POST',
            url:   '/admin/siteSetting/edit',
            headers: {
                'Content-Type': 'application/json'
            },
            data: _data
        };
        return $http(req);
    };
    this.find = function () {
        var req = {
            method: 'POST',
            url:   '/admin/siteSetting/find',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        return $http(req);
    }
});