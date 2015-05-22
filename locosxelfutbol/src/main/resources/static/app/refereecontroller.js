angular.module("app").controller("RefereeController", RefereeController);

RefereeController.$inject = ["footballManager", "$timeout", "$location"];

function RefereeController(footballManager, $timeout, $location) {

	var vm = this;
	vm.referees= footballManager.getReferees();
	vm.referee={};
	vm.modifyReferee=footballManager.modifyReferee;
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.referees=footballManager.referees;
	}
	
	vm.logout = function() {
		footballManager.logout();
		$location.path("/");
	};
	
	setTimeout( function (){
		vm.reload();}
	,500);		
	
	vm.modify = function(referee){
		vm.modifyReferee=footballManager.setModifyReferee(referee);
		vm.reload();
		$location.path('/modifyReferee');
	}
	
	vm.addReferee= function(referee){
		footballManager.addReferee(referee);
		vm.referee={};
		vm.reload();
		$location.path('/refereeAdmin');
	}
	
	vm.modifying= function(referee){
		footballManager.modifying(referee);
		vm.modifyReferee={};
		footballManager.setModifyReferee(vm.modifyReferee);
		vm.reload();
		$location.path('/refereeAdmin');
	}
	
	vm.deleteReferee = function(referee){
		footballManager.deleteReferee(referee);
		vm.referee={};
		vm.reload();
		$location.path('/refereeAdmin');
	}
	
	/*$scope.uploadFile = function(referee.image) {
	    var fd = new FormData();
	    //Take the first selected file
	    fd.append("file", referee.image[0]);

	    $http.post(uploadUrl, fd, {
	        withCredentials: true,
	        headers: {'Content-Type': undefined },
	        transformRequest: angular.identity
	    }).success( ...all right!... ).error( ..damn!... );

	};*/
};