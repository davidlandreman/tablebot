// declare a module
var module = angular.module('tablebot', []);

module.controller('TablebotController', function($scope){

	$scope.command = function(command) {
		console.log(command);
		//$http.get
	}
	
});