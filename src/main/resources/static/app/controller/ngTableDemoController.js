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
                            self.tableParams.reload();
                        }
                    );
                }, function () {
                    self.reason = 'dismissed';
                });
        };
    }]);

angular.module("demoApp")
    .controller("ModalDemoCtrl", ["$uibModalInstance", 'NgTableDemoService',
        function ($uibModalInstance, NgTableDemoService) {
            var modal = this;
            modal.showingTab = "ownerData";

            NgTableDemoService.getAllDitta().then(
                function (response) {
                    modal.companies = response;
                });
            
            modal.show = function (tabName, toReturn) {
                if (toReturn === true) {
                    return (modal.showingTab === tabName);
                }
    
                modal.showingTab = tabName;
            }
            
            modal.ok = function () {
                var data = {
                    name: modal.nameId,
                    surname: modal.surnameId,
                    company: modal.companiesSelected.name,
                    plate: modal.plateId
                };
                
                $uibModalInstance.close(data);
            };
            
            modal.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
    }]);