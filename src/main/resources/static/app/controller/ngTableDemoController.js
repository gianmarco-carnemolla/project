'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['$filter', 'NgTableParams', 'NgTableDemoService', '$uibModal', function ($filter, NgTableParams, NgTableDemoService, $uibModal) {
        var self = this;

        self.getAll = function (params) {
            return NgTableDemoService.getAll().then(
                function (response) {
                    response = $filter("filter")(response, params.filter());
                    return $filter("orderBy")(response, params.orderBy());
                }
            );
        };

        self.tableParams = new NgTableParams({}, {
            getData: self.getAll
        });

        self.addCar = function () {
            var modalInstance = $uibModal.open({
                templateUrl: "views/partials/demoModal/viewModal.html",
                controller: "ModalDemoCtrl",
                controllerAs: "modal",
                size: "lg",
                backdrop: "static"
            });

            modalInstance.result
                .then(function (data) {
                    self.reason = 'closed';
                    self.date = data;
                    NgTableDemoService.addAutomobile(data).then(
                        function (response) {
                            self.response = response;
                        }
                    );
                    window.location.reload();
                }, function () {
                    self.reason = 'dismissed';
                    console.info('Modal dismissed');
                });
        };
    }]);

angular.module("demoApp")
    .controller("ModalDemoCtrl", ["$uibModalInstance", 'NgTableDemoService',
        function ($uibModalInstance, NgTableDemoService) {
            var modal = this;

            NgTableDemoService.getAll().then(
                function (response) {
                    modal.cars = response;
                });
            
            modal.ok = function () {
                var data = {
                    name: modal.nameId,
                    surname: modal.surnameId,
                    company: modal.carsSelected.company,
                    plate: modal.plateId
                };
                
                $uibModalInstance.close(data);
            };
            
            modal.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
    }]);