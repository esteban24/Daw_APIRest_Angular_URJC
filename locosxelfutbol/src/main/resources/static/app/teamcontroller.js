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
	
	vm.logout = function() {
		footballManager.logout();
		$location.path("/");
	};
	
	vm.addTeam= function(team){
		team.win = 0;
		team.draw = 0;
		team.defeat = 0;
		team.points = 0;
		team.gc = 0;
		team.gf = 0;
		footballManager.addTeam(team);
		vm.team={};
		vm.reload();
		$location.path('/teamAdmin');
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