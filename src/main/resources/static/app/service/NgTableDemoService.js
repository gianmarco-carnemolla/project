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

    service.getAllDitta = function () {
        return $http.get('/api/ditta/all')
            .then(function (response) {
                return response.data;
            });
    };

    service.addAutomobile = function (requestBody) {
        return $http.post('/api/addAutomobile', requestBody)
            .then(function (response) {
                return response;
            });
    };

    service.getTypeahead = function() {
        return $http.get('https://jsonplaceholder.typicode.com/users')
            .then(function (response) {
                return response.data;
            });
    };
};