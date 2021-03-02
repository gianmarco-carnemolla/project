'use strict';

var demoApp = angular.module('demoApp', ['ngRoute', 'ui.bootstrap', 'ngResource', 'ngTable']);

demoApp.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "views/main.html"
        })
        .when("/demo", {
            templateUrl: "views/demo.html",
            controller: "demoCtrl",
            controllerAs: "demoController"
        })
        .when('/table', {
            templateUrl: "views/ngTable-demo.html",
            controller: "ngTableDemoCtrl",
            controllerAs: "ngTableDemoController"
        });
});