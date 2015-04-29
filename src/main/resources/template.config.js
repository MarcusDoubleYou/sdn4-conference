'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('{$}', {
                parent: 'entity',
                url: '/{$}',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/{$}/list.html',
                        controller: '{$$}Controller'
                    }
                }
            })
            .state('{$}Detail', {
                parent: 'entity',
                url: '/{$}s/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/{$}/detail.html',
                        controller: '{$$}DetailController'
                    }
                }
            });
    });
