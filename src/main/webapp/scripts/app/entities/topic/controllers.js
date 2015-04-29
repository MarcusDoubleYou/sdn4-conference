'use strict';

angular.module('registrarApp')

    .controller('TopicController', function ($scope, $state, Topic) {
        $scope.topics = [];

        $scope.loadAll = function() {
            Topic.query(function(result) {
               $scope.topics = result;
            });
        };
        $scope.loadAll();

        $scope.create = function () {

            console.log("saving topic");
            console.log($scope.topic);

            Topic.save($scope.topic,
                function () {
                    $('#saveTopicModal').modal('hide');
                    $scope.loadAll();
                });
        };

        $scope.update = function (id) {
            $scope.topic = Topic.get({id: id});
            $('#saveTopicModal').modal('show');
        };

        $scope.delete = function (id) {
            $scope.topic = Topic.get({id: id});
            $('#deleteTopicConfirmation').modal('show');
        };

        $scope.confirmDelete = function (id) {
            Topic.delete({id: id},
                function () {
                    var popup = $('#deleteTopicConfirmation');
                    popup.on('hidden.bs.modal', function(e) {
                        $scope.loadAll();
                        $state.transitionTo('topic');
                    });
                    $scope.clear();
                    popup.modal('hide');
                });
        };

        $scope.clear = function () {
            $scope.topic = {};
        };
    })

    .controller('TopicDetailController', function ($scope, $stateParams, Topic) {
        $scope.topic = {};
        $scope.load = function (id) {
            Topic.get({id: id}, function(result) {
              $scope.topic = result;
            });
        };
        $scope.load($stateParams.id);
    });
