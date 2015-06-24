angular.module("app").controller("GameController", GameController);

GameController.$inject = ["footballManager", "$timeout", "$location"];

function GameController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.tournaments=[];
	vm.tournament={};
	vm.games=[];
	vm.game={};
	vm.games= footballManager.getGames();
	vm.tournaments= footballManager.getTournaments();
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();
	
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.games=footballManager.games;
		vm.tournaments= footballManager.getTournaments();
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