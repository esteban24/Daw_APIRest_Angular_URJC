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
	vm.valido=false;
	vm.pass={};
	vm.mail={};
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

	var TeamResource = $resource('/team/equipos',  
		{save : {method : 'GET'}
	});
	
	var PlayerResource = $resource('/player/jugadores',  
			{save : {method : 'GET'}
		});
	
	var CourtResource = $resource('/courtAdmin/court',  
			{save : {method : 'GET'}
		});
	
	var TournamentResource = $resource('/tournamentAdmin/torneos',  
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

	var RefereeModifyResource = $resource('/refereeAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var CourtModifyResource = $resource('/courtAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var TournamentResource = $resource('/tournamentAdmin/:id',
			{id:'@id'},
			{deleteTournament:{method: 'DELETE'}},
			{save : {method : 'GET'}
	});
	
	/*var SessionResource = $resource('/adminLogin/seguridad', 
		{save : {method : 'POST'}
	});*/
	
	var PassResource = $resource('/')
	
	vm.getTeams = function() {
		vm.teams = TeamResource.query();
		return TeamResource.query();
	}
	
	vm.getPlayers = function() {
		vm.players = PlayerResource.query();
		return PlayerResource.query();
	}
	
	/*vm.getPlayersByTeam = function(team){
		vm.playersinteam = PlayerResource.query()
	}*/

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
	
	vm.login = function($mail, $pass, callback) {
		$http.post("/adminLogin/seguridad", {mail:$mail ,pass:$pass}).success(callback);
	}

	/*vm.islog = function() {
		return SessionResource.query();
	}

	vm.logout = function() {
		SessionResource.remove(function() {
		});
	}*/
	/*
	 * vm.signup = function(mail,pass){
	 * 
	 * for (var i = 0; i < vm.personas.length; i++) { if ((vm.personas[i].correo
	 * === mail)&&(vm.personas[i].pass === pass)) { vm.persona = vm.personas[i];
	 * $id=vm.persona.id;
	 * SignupResource.update({id:$id},true,function(){vm.showAlert("Te has
	 * registrasdo correctamente")}); } }
	 *  }
	 */

	vm.pass = function(pass, idpers) {
		$id = idpers;
		PassResource.update({
			id : $id
		}, pass, function() {
			vm.showAlert("Contraseña cambiada")
		});

	}
	vm.passCorrecta = function(pass, id) {
		$id = id;
		$pass = pass;
		vm.passcorrecta = PassCorrectaResource.get({
			id : $id
		}, {
			pass : $pass
		}, function() {
		});
		return vm.passcorrecta;
	}

	vm.reload = function() {
		vm.referees = vm.getReferees();
		vm.tournaments = vm.getTournaments();
		vm.teams = vm.getTeams();
		vm.player= vm.getPlayers();
		vm.courts = vm.getCourts();
	}

	/*function autoreload() {
		vm.reload();
		$timeout(autoreload, 1000);
	}

	autoreload();*/

}