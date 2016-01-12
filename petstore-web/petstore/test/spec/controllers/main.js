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
  
});
