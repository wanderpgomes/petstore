'use strict';

/**
 * @ngdoc function
 * @name petstoreApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the petstoreApp
 */
angular.module('petstoreApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
