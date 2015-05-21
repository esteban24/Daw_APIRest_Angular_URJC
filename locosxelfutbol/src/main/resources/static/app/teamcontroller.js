angular.module("app").controller("TeamController", TeamController);

TeamController.$inject = ["footballManager", "$timeout", "$location"];

function TeamController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.players= footballManager.getPlayers();
	
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.teams=footballManager.teams;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
};