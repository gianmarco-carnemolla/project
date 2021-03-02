'use strict';

angular.module('demoApp')
    .service('DemoService', DemoService);

DemoService.$inject = ['$http'];

function DemoService($http) {
    var service = this;

    service.getCompany = function (id) {
        return $http.get('/api/' + id).then(function (response) {
            return response.data.company;
        });
    };
    service.getPlate = function (id) {
        return $http.get('/api/' + id).then(function (response) {
            return response.data.plate;
        });
    };
};
