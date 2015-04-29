'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('timeslot', {
                parent: 'entity',
                url: '/timeslot',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/timeslot/list.html',
                        controller: 'TimeslotController'
                    }
                }
            })
            .state('timeslotDetail', {
                parent: 'entity',
                url: '/timeslots/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/timeslot/detail.html',
                        controller: 'TimeslotDetailController'
                    }
                }
            });
    });
