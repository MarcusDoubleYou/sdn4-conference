'use strict';

angular.module('registrarApp')

    .controller('SessionController', function ($scope, $state, Session) {
        $scope.sessions = [];

        $scope.loadAll = function() {
            Session.query(function(result) {
               $scope.sessions = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving session");
            console.log($scope.session);

            Session.save($scope.session,
                function () {
                    $('#saveSessionModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.session = Session.get({id: id});
            $('#saveSessionModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.session = Session.get({id: id});
            $('#deleteSessionConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Session.delete({id: id},
                function () {
                    var popup = $('#deleteSessionConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('session');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.session = {};
        };
    })

    .controller('SessionDetailController', function ($scope, $stateParams, Session) {
        $scope.session = {};
        $scope.load = function (id) {
            Session.get({id: id}, function(result) {
              $scope.session = result;
            });
        };
        $scope.load($stateParams.id);
    });
