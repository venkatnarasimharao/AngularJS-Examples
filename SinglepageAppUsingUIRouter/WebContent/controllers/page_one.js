app.controller("page_one",function($scope,$stateParams){
	$scope.var_one="I am from page one as you excepted...... !  :P";
	$scope.var_name=" Emplayee Name: " + $stateParams.e_id;
	$scope.var_names=" Employe Name: " +$stateParams.e_name; 
	$scope.var_namess=" Employe Salary: " +$stateParams.e_sal;
});