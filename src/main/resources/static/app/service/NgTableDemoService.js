'use strict';

angular.module('demoApp')
    .service('NgTableDemoService', NgTableDemoService);

NgTableDemoService.$inject = ['$http'];

function NgTableDemoService($http) {
    var service = this;

    service.getAll = function () {
        return $http.get('/api/all')
            .then(function (response) {
                return response.data;
            });
    };
};