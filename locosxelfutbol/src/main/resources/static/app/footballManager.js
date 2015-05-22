angular.module("app").service("footballManager", FootballManager);

FootballManager.$inject = [ "$resource", "$timeout", "$http" ];

function FootballManager($resource, $timeout, $http) {

	var vm = this;

	vm.team = {};
	vm.teams = [];
	vm.referee = {};
	vm.referees = [];
	vm.court = {};
	vm.courts = [];
	vm.tournament= {};
	vm.tournaments= [];
	vm.modifyReferee={};
	vm.modifyCourt={};
	vm.modifyPlayer={};
	vm.modifyTeam={};
	vm.valido=false;
	vm.pass={};
	vm.mail={};
	vm.mailuser={};
	vm.passuser={};
	vm.validouser=false;
	vm.player={};
	vm.players=[];
	vm.playersinteam=[];
	
	vm.getValido = function(){
		return vm.valido;
	}
	
	vm.setValido = function(cambio){
		vm.valido = cambio;
		return vm.valido;
	}
	
	vm.getValidouser = function(){
		return vm.validouser;
	}
	
	vm.setValidouser = function(cambio){
		vm.validouser = cambio;
		return vm.validouser;
	}

	var TeamResource = $resource('/team/:id',  
			{id:'@id'},
			{deleteTeam:{method: 'DELETE'}},
			{save : {method : 'GET'}
		});
	
	var PlayerResource = $resource('/player/:id',  
			{id:'@id'},
			{deletePlayer:{method: 'DELETE'}},
			{save : {method : 'GET'}
	});

	
	var RefereeResource = $resource('/refereeAdmin/:id',
			{id:'@id'},
			{deleteReferee:{method: 'DELETE'}},
			{save : {method : 'GET'}
	});
	
	var CourtResource = $resource('/courtAdmin/:id',
			{id:'@id'},
			{deleteCourt:{method: 'DELETE'}},
			{save : {method : 'GET'}
	});
	
	var TournamentResource = $resource('/tournamentAdmin/:id',
			{id:'@id'},
			{deleteTournament:{method: 'DELETE'}},
			{save : {method : 'GET'}
	});

	var RefereeModifyResource = $resource('/refereeAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var CourtModifyResource = $resource('/courtAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var TournamentModifyResource = $resource('/tournamentAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var PlayerModifyResource = $resource('/playerAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var PassResource = $resource('/')
	
	vm.getTeams = function() {
		vm.teams = TeamResource.query();
		return TeamResource.query();
	}
	
	vm.getPlayers = function() {
		vm.players = PlayerResource.query();
		return PlayerResource.query();
	}

	vm.getReferees = function() {
		vm.referees = RefereeResource.query();
		return RefereeResource.query();
	}
	
	vm.getCourts = function() {
		vm.courts = CourtResource.query();
		return CourtResource.query();
	}
	
	vm.getTournaments = function() {
		vm.tournaments = TournamentResource.query();
		return TournamentResource.query();
	}
	
	vm.setModifyReferee= function(referee){
		vm.modifyReferee=referee;
		return vm.modifyReferee;
	}
	
	vm.setModifyCourt= function(court){
		vm.modifyCourt=court;
		return vm.modifyCourt;
	}
	
	vm.setModifyTournament= function(tournament){
		vm.modifyTournament=tournament;
		return vm.modifyTournament;
	}
	
	vm.setModifyPlayer= function(player){
		vm.modifyPlayer=player;
		return vm.modifyPlayer;
	}
	
	vm.setModifyTeam= function(team){
		vm.modifyTeam=team;
		return vm.modifyTeam;
	}
	
	vm.addReferee= function(addReferee){
		RefereeResource.save(addReferee);
	}
	
	vm.addCourt= function(addCourt){
		CourtResource.save(addCourt);
	}
	
	vm.modifying= function(referee){
		$id=referee.id;
		RefereeModifyResource.update({id:$id},referee);
	}
	
	vm.modifyingcourt= function(court){
		$id=court.id;
		CourtModifyResource.update({id:$id},court);
	}
	
	vm.modifyingtournament= function(tournament){
		$id=tournament.id;
		TournamentModifyResource.update({id:$id},tournament);
	}
	
	vm.modifyingplayer= function(player){
		$id=player.id;
		PlayerModifyResource.update({id:$id},player);
	}
	
	vm.modifyingteam= function(team){
		$id=player.id;
		TeamModifyResource.update({id:$id},team);
	}
	
	vm.deleteReferee= function(referee){
		$id=referee.id;
		RefereeResource.deleteReferee({id:$id});
	}
	
	vm.deleteCourt= function(court){
		$id=court.id;
		CourtResource.deleteCourt({id:$id});
	}
	
	vm.deleteTournament= function(tournament){
		$id=tournament.id;
		TournamentResource.deleteTournament({id:$id});
	}
	
	vm.deletePlayer= function(player){
		$id=player.id;
		PlayerResource.deletePlayer({id:$id});
	}
	
	vm.deleteTeam= function(team){
		$id=team.id;
		TeamResource.deleteTeam({id:$id});
	}
	
	vm.login = function($mail, $pass, callback) {
		$http.post("/adminLogin/seguridad", {mail:$mail ,pass:$pass}).success(callback);
	}
	
	vm.loginuser = function($mailuser, $passuser, callback) {
		$http.post("/adminLogin/seguridadUsuario", {mail:$mailuser ,pass:$passuser}).success(callback);
	}

	/*vm.islog = function() {
		return SessionResource.query();
	}*/

	vm.logout = function() {
		vm.setValido(false);
	}

	vm.reload = function() {
		vm.referees = vm.getReferees();
		vm.teams = vm.getTeams();
		vm.player= vm.getPlayers();
		vm.courts = vm.getCourts();
		vm.tournaments= vm.getTournaments();
	}

	/*function autoreload() {
		vm.reload();
		$timeout(autoreload, 1000);
	}

	autoreload();*/

}