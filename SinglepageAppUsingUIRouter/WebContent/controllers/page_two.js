app.controller("page_two",function($scope,$stateParams){
	$scope.var_two="I am from page two as you excepted in your mind...... !  :P";
	$scope.var_name=" Emplayee Name: " + $stateParams.e_id;
	$scope.var_names=" Employe Name: " +$stateParams.e_name; 
	$scope.var_namess=" Employe Salary: " +$stateParams.e_sal;
});