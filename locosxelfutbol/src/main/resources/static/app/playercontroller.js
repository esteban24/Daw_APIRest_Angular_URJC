angular.module("app").controller("PlayerController", PlayerController);

PlayerController.$inject = ["footballManager", "$timeout", "$location"];

function PlayerController(footballManager, $timeout, $location) {

	var vm = this;

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.players=footballManager.players;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
};