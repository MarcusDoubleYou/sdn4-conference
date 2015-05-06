'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('talk', {
                parent: 'entity',
                url: '/talk',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/talk/list.html',
                        controller: 'TalkController'
                    }
                }
            })
            .state('talkDetail', {
                parent: 'entity',
                url: '/talks/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/talk/detail.html',
                        controller: 'TalkDetailController'
                    }
                }
            });
    });
