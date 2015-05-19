angular.module("app").service("footballManager", FootballManager);

FootballManager.$inject = [ "$resource", "$timeout" ];

function FootballManager($resource, $timeout) {

	var vm = this;

	vm.team = {};
	vm.teams = [];
	vm.referee = {};
	vm.referees = [];
	vm.modifyReferee={};

	var TeamResource = $resource('/team/equipos',  
		{save : {method : 'GET'}
	});

	/*var RefereeUserResource= $resource('/referee/:id',
			{id:'@id'},
			{save : {method : 'POST'}
	});*/
	
	var RefereeResource = $resource('/refereeAdmin/:id',
			{id:'@id'},
			{save : {method : 'GET'}
	});

	var RefereeModifyResource = $resource('/refereeAdmin/:id', 
			{id:'@id'},
			{'update' : {method : 'PUT'}
	});
	
	var SessionResource = $resource('/adminLogin/seguridad', 
		{save : {method : 'GET'}
	});
	
	var PassResource = $resource('/')
	
	vm.getTeams = function() {
		vm.teams = TeamResource.query();
		return TeamResource.query();
	}

	vm.getReferees = function() {
		vm.referees = RefereeResource.query();
		return RefereeResource.query();
	}

	vm.setModifyReferee= function(referee){
		vm.modifyReferee=referee;
		return vm.modifyReferee;
	}
	
	vm.modifying= function(referee){
		$id=referee.id;
		RefereeModifyResource.update({id:$id},referee,function(){vm.showAlert(referee.name+"modificado")})
	}
	
	vm.login = function(mail, pass) {
		vm.datos = {};
		vm.datos.mail = mail;
		vm.datos.pass = pass;
		SessionResource.save(vm.datos, function() {
		});
	}

	vm.islog = function() {
		return SessionResource.query();
	}

	vm.logout = function() {
		SessionResource.remove(function() {
		});
	}
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
		vm.teams = vm.getTeams();
	}

	function autoreload() {
		vm.reload();
		$timeout(autoreload, 1000);
	}

	autoreload();

}