'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('topic', {
                parent: 'entity',
                url: '/topic',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/topic/list.html',
                        controller: 'TopicController'
                    }
                }
            })
            .state('topicDetail', {
                parent: 'entity',
                url: '/topics/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/topic/detail.html',
                        controller: 'TopicDetailController'
                    }
                }
            });
    });
