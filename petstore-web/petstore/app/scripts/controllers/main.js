'use strict';

/**
 * @ngdoc function
 * @name petstoreApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the petstoreApp
 */
angular.module('petstoreApp').controller('MainCtrl', function ($scope, $http) {

    $scope.name = '';
    $scope.status = '';

    $scope.addPet = function(){
    	$http.post('http://localhost:8080/pet', {name: $scope.name, status: $scope.status}).then(function successCallback(response) {
		    
		 }, function errorCallback(response) {
		    
		 });
    };
  });
