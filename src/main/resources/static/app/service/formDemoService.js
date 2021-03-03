'use strict';

angular.module('demoApp')
    .service('formDemoService', formDemoService);

formDemoService.$inject = ['$http'];

function formDemoService($http) {
    var service = this;

    service.addAutomobile = function (requestBody) {
        return $http.post('/api/addAutomobile', requestBody)
            .then(function (response) {
                return response;
            });
    };

};