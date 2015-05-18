angular.module("app").service("footballManager", FootballManager);

FootballManager.$inject = [ "$resource", "$timeout" ];

function FootballManager($resource, $timeout) {

	var vm= this;
	
	vm.team={};
	vm.teams=[];
	vm.referee={};
	vm.referees=[];
	
	var TeamResource = $resource('/team/:id',
			{id:'@id'},
			{save: {method: 'POST'}}
	);
	
	var RefereeResource = $resource('/referee/:id',
			{id:'@id'},
			{save: {method: 'POST'}}
	);
	
	vm.getTeams= function(){
		vm.teams=TeamResource.query();
		return TeamResource.query();
	}
	
	vm.getReferees= function(){
		vm.referees=RefereeResource.query();
		return Referee.query();
	}
	
	vm.reload= function(){
		vm.teams=vm.getTeams();
	}
	
	function autoreload(){
		vm.reload();
		$timeout(autoreload, 1000);
	}
	
	autoreload();
	
	
}