var app=angular.module("todoapp",[]);

app.controller("TodoCtrl",function($scope,$http) {
	
	$scope.form = {
            id : -1,
            job : ""
          };
	
	 _refreshPageData();
	 
	$scope.addJob= function(){
		console.log($scope.form.id);
		var method = "";
        var url = "";
        if (!$scope.form.id||$scope.form.id==-1) {
        	
        	method = "POST";
            url = 'add';
            console.log("post angular controller "+$scope.form.id)
        } else {
        
            method = "PUT";
            url = 'editJob/' + $scope.form.id;
            console.log("put angular controller "+$scope.form.id)
        }

        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.form),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then( _success, _error );
    };
		
    
    
		$scope.removeJob=function(joblist){
			console.log("I/m in DELETE functionality");
			
			$http({
				 method:"DELETE",
				 url:"deleteJob/"+ joblist.id
			}).then( _success, _error );
        };
        
        
        
        $scope.editJob=function(joblist){
        	console.log("I'm in edit functionality");
        	$scope.form.job=joblist.job;
        	$scope.form.id=joblist.id;
       
        };
        
        
        
        function _refreshPageData() {
        	$http({
				 method:"GET",
					url:"getAllJobs"
         	}).then(function successCallback(response){
				console.log(response.data);
				$scope.jobs=response.data;
			}, function errorCallback(response){
				console.log(response.statusText);
			});
        }
        
        
        function _success(response) {
            _refreshPageData();
            _clearForm()
        }
        
        
        function _error(response) {
            console.log(response.statusText);
        }
 
       
        function _clearForm() {
            $scope.form.job = "";
            $scope.form.id=-1;
        };
 });
