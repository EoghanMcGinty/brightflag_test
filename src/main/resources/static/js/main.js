var app = angular.module('bfCodeTest', []);

app.controller('studentCtrl', function($scope, $location, $http) {
	console.log("StudentCtrl loaded.");
	
	$http.get('http://localhost:8080/api/getStudents')
	.then(function(response) {
		$scope.students = response.data;
	});
});

app.controller('subjectCtrl', function($scope, $location, $http) {
	console.log("SubjectCtrl loaded.");
	
	$http.get('http://localhost:8080/api/getSubjects')
	.then(function(response) {
		$scope.subjects = response.data;
	});
});

app.controller('resultCtrl', function($scope, $location, $http) {
	console.log("resultCtrl loaded.");
	
	$http.get('http://localhost:8080/api/getResults')
	.then(function(response) {
		$scope.results = response.data;
	});
});

app.controller('enrollCtrl', function ($scope, $http) {
  console.log("enrollCtrl loaded.");
  $scope.enrollForm = {};
  $scope.enroll = function(){
	  //validate
	  $http.post('http://localhost:8080/api/enroll', $scope.enrollForm)
	  .then(function(response){
		  //success
	  });
      console.log($scope.subjectName);
  }
});

