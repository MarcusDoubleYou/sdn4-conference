'use strict';

angular.module('registrarApp')

    .controller('SpeakerController', function ($scope, $state, Speaker) {
        $scope.speakers = [];

        $scope.loadAll = function() {
            Speaker.query(function(result) {
               $scope.speakers = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving speaker");
            console.log($scope.speaker);

            Speaker.save($scope.speaker,
                function () {
                    $('#saveSpeakerModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.speaker = Speaker.get({id: id});
            $('#saveSpeakerModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.speaker = Speaker.get({id: id});
            $('#deleteSpeakerConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Speaker.delete({id: id},
                function () {
                    var popup = $('#deleteSpeakerConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('speaker');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.speaker = {};
        };
    })

    .controller('SpeakerDetailController', function ($scope, $stateParams, Speaker) {
        $scope.speaker = {};
        $scope.load = function (id) {
            Speaker.get({id: id}, function(result) {
              $scope.speaker = result;
            });
        };
        $scope.load($stateParams.id);
    });
