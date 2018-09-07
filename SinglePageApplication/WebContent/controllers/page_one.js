app.controller("ctrl_one",function($scope,$routeParams){
	$scope.var_one="i am from page One..!";
	$scope.var_param=$routeParams.param1 +
	$routeParams.param2+
	$routeParams.param3;
});