'use strict';

angular.module('registrarApp')

    .controller('TalkController', function ($scope, $state, Talk) {
        $scope.talks = [];

        $scope.loadAll = function() {
            Talk.query(function(result) {
               $scope.talks = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving talk");
            console.log($scope.talk);

            Talk.save($scope.talk,
                function () {
                    $('#saveTalkModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.talk = Talk.get({id: id});
            $('#saveTalkModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.talk = Talk.get({id: id});
            $('#deleteTalkConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Talk.delete({id: id},
                function () {
                    var popup = $('#deleteTalkConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('talk');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.talk = {};
        };
    })

    .controller('TalkDetailController', function ($scope, $stateParams, Talk) {
        $scope.talk = {};
        $scope.load = function (id) {
            Talk.get({id: id}, function(result) {
              $scope.talk = result;
            });
        };
        $scope.load($stateParams.id);
    });
