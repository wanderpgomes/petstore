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

    $scope.pets = [];

    $scope.addPet = function(){
    	if (name && status){
	    	$http.post('http://localhost:8080/pet', {name: $scope.name, status: $scope.status}).then(function success(response) {

	    		$scope.clearForm();
	    		$scope.getPets();
			    
			 }, function error(response) {
			    
			 });
		}
    };

    $scope.getPets = function(){
    	$http.get('http://localhost:8080/pet').then(function success(response) {
		 	
		 	$scope.pets = response.data;

		 }, function error(response) {
		    
		 });
    };

    $scope.clearForm =  function() {
    	$scope.name = '';
    	$scope.status = '';
    };

    $scope.getPets();

  });
