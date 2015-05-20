angular.module("app").controller("TournamentController", TournamentController);

TournamentController.$inject = ["footballManager", "$timeout", "$location"];

function TournamentController(footballManager, $timeout, $location) {

	var vm = this;
	vm.tournaments= footballManager.getTournaments();
	vm.tournament={};
	

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.tournaments=footballManager.tournaments;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
};