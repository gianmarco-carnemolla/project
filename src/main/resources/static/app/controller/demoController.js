'use strict';

angular.module("demoApp")
    .controller('demoCtrl', ['$http', 'DemoService', function ($http, DemoService) {
        var self = this;

        self.buttonMessageCompany = "Get Car Company";
        self.buttonMessagePlate = "Get Car Plate";
        self.tooltipCompany = "Click here for get company";
        self.tooltipPlate = "Click here for get plate";
        
        self.getCompany = function (id) {
            if (id != '' && id != undefined) {
                DemoService.getCompany(id).then(
                    function (response) {
                        self.response = response;
                    }
                );
            }
        };
        self.getPlate = function (id) {
            if (id != '' && id != undefined) {
                DemoService.getPlate(id).then(
                    function (response) {
                        self.response = response;
                    }
                );
            }
        };
    }]);