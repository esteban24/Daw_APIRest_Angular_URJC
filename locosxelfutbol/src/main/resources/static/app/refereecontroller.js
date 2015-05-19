angular.module("app").controller("RefereeController", RefereeController);

RefereeController.$inject = ["footballManager", "$timeout", "$location"];

function RefereeController(footballManager, $timeout, $location) {

	var vm = this;
	vm.referees= footballManager.getReferees();
	vm.referee={};
	vm.modifyReferee=footballManager.modifyReferee;

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.referees=footballManager.referees;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);		
	
	vm.modify = function(referee){
		vm.modifyReferee=footballManager.setModifyReferee(referee);
		vm.reload();
		$location.path('/modifyReferee');
	}
	
	vm.modifying= function(referee){
		footballManager.modifying(referee);
		vm.modifyReferee={};
		footballManager.setModifyReferee(vm.modifyReferee);
		vm.reload();
		$location.path('/refereeAdmin')
	}
};