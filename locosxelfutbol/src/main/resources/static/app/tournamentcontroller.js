angular.module("app").controller("TournamentController", TournamentController);

TournamentController.$inject = ["footballManager", "$timeout", "$location"];

function TournamentController(footballManager, $timeout, $location) {

	var vm = this;
	vm.tournaments= footballManager.getTournaments();
	vm.tournament={};
	vm.modifyTournament=footballManager.modifyTournament;
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.tournaments=footballManager.tournaments;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);		
	
	/*ojooooooo*/vm.modify3 = function(tournament){
		vm.modifyTournament=footballManager.setModifyTournament(tournament);
		vm.reload();
		$location.path('/modifyTournament');
	}
	
	vm.modifyingtournament= function(tournament){
		footballManager.modifyingtournament(tournament);
		vm.modifyTournament={};
		footballManager.setModifyTournament(vm.modifyTournament);
		vm.reload();
		$location.path('/tournamentAdmin');
	}
	
	vm.deleteTournament = function(tournament){
		footballManager.deleteTournament(tournament);
		vm.tournament={};
		vm.reload();
		$location.path('/tournamentAdmin');
	}
};