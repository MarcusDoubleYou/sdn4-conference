'use strict';

angular.module('registrarApp')

    .controller('{$$}Controller', function ($scope, $state, {$$}) {
        $scope.{$}s = [];

        $scope.loadAll = function() {
            {$$}.query(function(result) {
               $scope.{$}s = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving {$}");
            console.log($scope.{$});

            {$$}.save($scope.{$},
                function () {
                    $('#save{$$}Modal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.{$} = {$$}.get({id: id});
            $('#save{$$}Modal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.{$} = {$$}.get({id: id});
            $('#delete{$$}Confirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            {$$}.delete({id: id},
                function () {
                    var popup = $('#delete{$$}Confirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('{$}');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.{$} = {};
        };
    })

    .controller('{$$}DetailController', function ($scope, $stateParams, {$$}) {
        $scope.{$} = {};
        $scope.load = function (id) {
            {$$}.get({id: id}, function(result) {
              $scope.{$} = result;
            });
        };
        $scope.load($stateParams.id);
    });
