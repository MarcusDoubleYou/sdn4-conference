'use strict';

angular.module('registrarApp')

    .config(function ($stateProvider) {
        $stateProvider
            .state('statistics', {
                parent: 'entity',
                url: '/topics/popular',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/statistics/detail.html',
                        controller: 'StatisticsController'
                    }
                }
            })
    });
