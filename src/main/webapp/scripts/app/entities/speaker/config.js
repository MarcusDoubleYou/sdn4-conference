'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('speaker', {
                parent: 'entity',
                url: '/speaker',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/speaker/list.html',
                        controller: 'SpeakerController'
                    }
                }
            })
            .state('speakerDetail', {
                parent: 'entity',
                url: '/speakers/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/speaker/detail.html',
                        controller: 'SpeakerDetailController'
                    }
                }
            });
    });
