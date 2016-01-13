'use strict';

describe('Controller: MainCtrl', function () {

  // load the controller's module
  beforeEach(module('petstoreApp'));

  var scope, httpBackend, http, controller;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope, $httpBackend, $http) {
    scope = $rootScope.$new();
    httpBackend = $httpBackend;
    http = $http;
    controller = $controller;
    httpBackend.when("GET", "http://localhost:8080/pet").respond([{}, {}, {}]);

    controller('MainCtrl', {
      $scope: scope,
      $http: http
    });
  }));

  it('should load a list of pets', function () {
    
    httpBackend.expectGET("http://localhost:8080/pet");

    httpBackend.flush();

    expect(scope.pets.length).toBe(3);
  });

  

  it('should add a new pet', function() {
    var pet = {name: 'pet1', status: 'sold'};
    httpBackend.when("POST", "http://localhost:8080/pet",
        function(postData) {
            var jsonData = JSON.parse(postData);
            expect(jsonData.name).toBe(pet.name);
            expect(jsonData.status).toBe(pet.status);
            return true;
        }
    ).respond(200, true );

    scope.name = pet.name;
    scope.status = pet.status;

    scope.addPet();

    httpBackend.flush();
  });
  
});
