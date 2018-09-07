app.controller("page_two",function($scope,$routeParams){
	$scope.var_two="i am from page Two ....!";
		$scope.var_params=$routeParams.param1 +
		$routeParams.param2;
});