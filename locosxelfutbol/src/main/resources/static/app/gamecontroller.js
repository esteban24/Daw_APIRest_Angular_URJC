angular.module("app").controller("GameController", GameController);

GameController.$inject = ["footballManager", "$timeout", "$location"];

function GameController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.tournaments=[];
	vm.tournament={};
	vm.selectedTournamentId = {};
	vm.games=[];
	vm.game={};
	vm.goalsLocal = {};
	vm.goalsVisitant = {};
	vm.error = false;
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
	
	vm.setTournamentId = function setTournamentId(id){
		vm.error = false;
		vm.goalsLocal = {};
		vm.goalsVisitant = {};
		vm.selectedTournamentId = id;
	};
	
	vm.sendGoals = function(local, visitant){
		var uno = document.getElementById("local"+local);
		var dos = document.getElementById("visitant"+visitant);
		if((uno.value < "0") || (dos.value < "0")){
			vm.error = true;
		}else{
			vm.error = false;
			vm.setGoalsLocal(uno.value);
			vm.setGoalsVisitant(dos.value);
			alert(vm.goalsLocal);
			alert(vm.goalsVisitant);
		};
	};
	
	vm.setGoalsLocal = function(goals){
		vm.goalsLocal = goals
	};
	
	vm.setGoalsVisitant = function(goals){
		vm.goalsVisitant = goals
	}
};