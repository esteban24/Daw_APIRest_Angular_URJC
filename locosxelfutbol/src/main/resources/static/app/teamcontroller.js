angular.module("app").controller("TeamController", TeamController);

TeamController.$inject = ["footballManager", "$timeout", "$location"];

function TeamController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.teams= footballManager.getTeams();
	vm.team={};
	vm.modifyTeam=footballManager.modifyTeam;
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();

	
	vm.teams= footballManager.getTeams();
	
	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.teams=footballManager.teams;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
	
	/*ojooooooo*/vm.modify5 = function(team){
		vm.modifyTeam=footballManager.setModifyTeam(team);
		vm.reload();
		$location.path('/modifyTeam');
	}
	
	vm.modifyingteam= function(team){
		footballManager.modifyingteam(team);
		vm.modifyTeam={};
		footballManager.setModifyTeam(vm.modifyTeam);
		vm.reload();
		$location.path('/teamAdmin');
	}
	
	vm.deleteTeam = function(team){
		footballManager.deleteTeam(team);
		vm.team={};
		vm.reload();
		$location.path('/teamAdmin');
	}
};