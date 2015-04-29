'use strict';

angular.module('registrarApp')

    .controller('TrackController', function ($scope, $state, Track) {
        $scope.tracks = [];

        $scope.loadAll = function() {
            Track.query(function(result) {
               $scope.tracks = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving track");
            console.log($scope.track);

            Track.save($scope.track,
                function () {
                    $('#saveTrackModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.track = Track.get({id: id});
            $('#saveTrackModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.track = Track.get({id: id});
            $('#deleteTrackConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Track.delete({id: id},
                function () {
                    var popup = $('#deleteTrackConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('track');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.track = {};
        };
    })

    .controller('TrackDetailController', function ($scope, $stateParams, Track) {
        $scope.track = {};
        $scope.load = function (id) {
            Track.get({id: id}, function(result) {
              $scope.track = result;
            });
        };
        $scope.load($stateParams.id);
    });
