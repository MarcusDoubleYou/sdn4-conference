'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('track', {
                parent: 'entity',
                url: '/track',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/track/list.html',
                        controller: 'TrackController'
                    }
                }
            })
            .state('trackDetail', {
                parent: 'entity',
                url: '/tracks/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/track/detail.html',
                        controller: 'TrackDetailController'
                    }
                }
            });
    });
