'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('session', {
                parent: 'entity',
                url: '/session',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/session/list.html',
                        controller: 'SessionController'
                    }
                }
            })
            .state('sessionDetail', {
                parent: 'entity',
                url: '/sessions/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/session/detail.html',
                        controller: 'SessionDetailController'
                    }
                }
            });
    });
