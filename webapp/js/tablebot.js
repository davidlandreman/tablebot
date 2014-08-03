// declare a module
var module = angular.module('tablebot', []);

module.controller('TablebotController', function($http, $scope){

	$scope.command = function(command) {
		console.log(command);
		$http.get("/app/command.groovy?" + command).success(function(data){
			
		});
	}
	
});