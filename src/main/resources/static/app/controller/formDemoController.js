'use strict';

angular.module("demoApp")
    .controller('formDemoCtrl', ['$http', 'formDemoService', 'NgTableDemoService', function ($http, formDemoService, NgTableDemoService) {
        var self = this;

        self.submit = function () {
            
            var data = {
                name: self.nameId,
                surname: self.surnameId,
                company: self.carsSelected.company,
                plate: self.plateId
            };
            
            formDemoService.addAutomobile(data).then(
                function (response) {
                    self.response = response;
                }
            );
        };

        NgTableDemoService.getAll().then(
            function (response) {
                self.cars = response;
            });

    }]);