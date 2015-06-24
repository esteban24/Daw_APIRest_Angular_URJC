angular.module("app").controller("RankingController", RankingController);

RankingController.$inject = ["footballManager", "$timeout", "$location"];

function RankingController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.tournaments=[];
	vm.tournament={};
	vm.games=[];
	vm.game={};
	vm.teams=[];
	vm.team={};
	vm.games= footballManager.getGames();
	vm.tournaments= footballManager.getTournaments();
	vm.teams= footballManager.getTeams();
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();
	
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.games=footballManager.games;
		vm.tournaments= footballManager.getTournaments();
		vm.teams= footballManager.getTeams();
		vm.valido = footballManager.getValido();
		vm.validouser= footballManager.getValidouser();
	}
	
	setTimeout( function (){
		vm.reload();}
	,50000);
	
	
	vm.logout = function() {
		footballManager.logout();
		$location.path("/");
	};
};