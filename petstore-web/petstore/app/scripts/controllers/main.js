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
    $scope.category = '';

    $scope.pets = [];

    $scope.selectedPet = null;

    $scope.addPet = function(){
    	if ($scope.name && $scope.status){
	    	$http.post('http://localhost:8080/pet', {name: $scope.name, status: $scope.status, category: $scope.category}).then(function success(response) {

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

    $scope.selectPet = function(pet){
         $http.get('http://localhost:8080/pet/' + pet.id).then(function success(response) {

            $scope.selectedPet = response.data;
            
        }, function error(response) {
            
        });
        

    };

    $scope.deletePet = function(pet){
        $http.delete('http://localhost:8080/pet/' + pet.id).then(function success(response) {

            $scope.getPets();
            $scope.selectedPet = null;
            
        }, function error(response) {
            
        });
        
    };


    $scope.clearForm =  function() {
    	$scope.name = '';
    	$scope.status = '';
        $scope.category = '';
    };

    $scope.getPets();

  });
