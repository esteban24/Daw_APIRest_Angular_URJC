angular.module("app").controller("RefereeController", RefereeController);

RefereeController.$inject = ["footballManager", "$timeout", "$location"];

function RefereeController(footballManager, $timeout, $location) {

	var vm = this;

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.referees=footballManager.referees;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
};