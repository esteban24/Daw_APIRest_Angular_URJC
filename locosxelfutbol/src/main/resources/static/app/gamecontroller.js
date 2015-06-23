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

	
	vm.games= footballManager.getGames();
	
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.games=footballManager.games;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
	
	/*ojooooooo*/vm.modify5 = function(team){
		vm.modifyTeam=footballManager.setModifyTeam(team);
		vm.reload();
		$location.path('/modifyTeam');
	}
	
	vm.logout = function() {
		footballManager.logout();
		$location.path("/");
	};
};