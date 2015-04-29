'use strict';

angular.module('registrarApp')

    .controller('TimeslotController', function ($scope, $state, Timeslot) {
        $scope.timeslots = [];

        $scope.loadAll = function() {
            Timeslot.query(function(result) {
               $scope.timeslots = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving timeslot");
            console.log($scope.timeslot);

            Timeslot.save($scope.timeslot,
                function () {
                    $('#saveTimeslotModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.timeslot = Timeslot.get({id: id});
            $('#saveTimeslotModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.timeslot = Timeslot.get({id: id});
            $('#deleteTimeslotConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Timeslot.delete({id: id},
                function () {
                    var popup = $('#deleteTimeslotConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('timeslot');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.timeslot = {};
        };
    })

    .controller('TimeslotDetailController', function ($scope, $stateParams, Timeslot) {
        $scope.timeslot = {};
        $scope.load = function (id) {
            Timeslot.get({id: id}, function(result) {
              $scope.timeslot = result;
            });
        };
        $scope.load($stateParams.id);
    });
