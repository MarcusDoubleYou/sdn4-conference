'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('conference', {
                parent: 'entity',
                url: '/conference',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/conference/list.html',
                        controller: 'ConferenceController'
                    }
                }
            })
            .state('conferenceDetail', {
                parent: 'entity',
                url: '/conferences/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/conference/detail.html',
                        controller: 'ConferenceDetailController'
                    }
                }
            });
    });
