'use strict';

angular.module('demoApp')
    .service('DemoService', DemoService);

DemoService.$inject = ['$http', '$resource'];

function DemoService($http, $resource) {
    var service = this;

    service.getCompany = function (id) {
        return $resource('/api/:id', {}, { get: { method: 'GET', params: { id: '@id' } } });
    };
    service.getPlate = function (id) {
        return $http.get('/api/' + id).then(function (response) {
            return response.data.plate;
        });
    };
};
