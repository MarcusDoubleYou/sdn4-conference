'use strict';

angular.module('registrarApp')

    .controller('ConferenceController', function ($scope, $state, Conference) {
        $scope.conferences = [];

        $scope.loadAll = function() {
            Conference.query(function(result) {
               $scope.conferences = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving conference");
            console.log($scope.conference);

            Conference.save($scope.conference,
                function () {
                    $('#saveConferenceModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.conference = Conference.get({id: id});
            $('#saveConferenceModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.conference = Conference.get({id: id});
            $('#deleteConferenceConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Conference.delete({id: id},
                function () {
                    var popup = $('#deleteConferenceConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('conference');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.conference = {};
        };
    })

    .controller('ConferenceDetailController', function ($scope, $stateParams, Conference) {
        $scope.conference = {};
        $scope.load = function (id) {
            Conference.get({id: id}, function(result) {
              $scope.conference = result;
            });
        };
        $scope.load($stateParams.id);
    });
