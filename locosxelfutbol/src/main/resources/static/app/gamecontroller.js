angular.module("app").controller("GameController", GameController);

GameController.$inject = ["footballManager", "$timeout", "$location"];

function GameController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.tournaments=[];
	vm.tournament={};
	vm.selectedTournamentId = {};
	vm.games=[];
	vm.game={};
	vm.goalsLocal = 0;
	vm.goalsVisitant = 0;
	vm.teamLocal = "";
	vm.teamVisitant = "";
	vm.error = false;
	vm.preparedToSend = false;
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
	
	//Función que se llama al pulsar en un torneo para obtener el id del torneo que el usuario ha seleccionado
	vm.setTournamentId = function setTournamentId(id){
		//Cada vez que pulsamos un torneo debemos inicializar las variables del controlador para que no haya problemas
		vm.preparedToSend = false;
		vm.error = false;
		vm.goalsLocal = 0;
		vm.goalsVisitant = 0;
		vm.teamLocal = "";
		vm.teamVisitant = "";
		//Asignamos el valor del id que nos pasa el usuario a la variable del controlador
		vm.selectedTournamentId = id;
	};
	
	//Función que recoge el id del torneo para obtener los valores de los inputs del usuario
	vm.sendGoals = function(id){
		//Obtenemos los valores de los inputs y los almacenamos en sus correspondientes variables
		var goalsLocal = document.getElementById("local"+id).value;
		var goalsVisitant = document.getElementById("visitant"+id).value;
		var teamLocal = document.getElementById("teamLocal").value;
		var teamVisitant = document.getElementById("teamVisitant").value;
		//Si los goles son menor que 0 o los equipos son iguales mandamos un mensaje de error y establecemos
		//la variable para preparar el envío a BBDD a false
		if((goalsLocal < 0) || (goalsVisitant < 0) || (teamLocal == teamVisitant)){
			vm.error = true;
			vm.preparedToSend = false;
		//En caso de que los parámetros sean correctos actualizamos las variables del controlador por  
		//las introducidas por el usuario	
		}else{
			vm.error = false;
			vm.setGoalsLocal(goalsLocal);
			vm.setGoalsVisitant(goalsVisitant);
			vm.setTeamLocal(teamLocal);
			vm.setTeamVisitant(teamVisitant);
			//alerts para comprobar el valor de las variables (descomentar para probarlo en la aplicación visualmente)
			alert(vm.goalsLocal);
			alert(vm.goalsVisitant);
			alert(vm.teamLocal);
			alert(vm.teamVisitant);
			vm.preparedToSend = true;
		};
	};
	
	//TODO esteban: método importante que creará en partido en el torneo correspondiente
	vm.generateGame = function (idLocalTeam, idVisitantTeam, idTournament){
		var pointsWin = 3;
		var pointsDraw = 1;
		var pointsLost = 0;
		if(vm.preparedToSend){
			/* Método que actualiza por una parte el equipo con sus estadísticas y crea el partido
			 * 
			 * Crear updateTeamFromTournament que dado un id de torneo, busca por id el equipo y modifica sus estadísticas
			 * 
			 * Crear addGame que añade un partido con los equipos seleccionados en el torneo con el id que le pasamos
			 * 
			 * Nota: Si es muy complicado, eliminar lo de tener más de un torneo (solo dejar el primero que teníamos)
			 * 	     y luego en las cabeceras de estos métodos, únicamente quitar idTournmanetcy actualizar los equipos en general
			 *       así como los partidos.
			 *       
			 *       Estos métodos tendrán que crearse en footballManager.js y desde alli llamar al servicio REST de UPDATE que hay
			 *       que crearse en torneo (tanto addGame como updateTeamFromTournament).
			 * 
			if(vm.goalsLocal > vm.goalsVisitant){
				footballManager.updateTeamFromTournament(idTournament, idLocalTeam, pointsWin, vm.goalsLocal, vm.goalsVisitant);
				footballManager.updateTeamFromTournament(idTournament, idVisitantTeam, pointsLost, vm.goalsVisitant, vm.goalsLocal);
				footballManager.addGame(idTournament, idLocalTeam, idVisistantTeam, vm.goalsLocal, vm.goalsVisitant);
			}else if(vm.goalsLocal == vm.goalsVisitant){
				footballManager.updateTeamFromTournament(idTournament, idLocalTeam, pointsDraw, vm.goalsLocal, vm.goalsVisitant);
				footballManager.updateTeamFromTournament(idTournament, idVisitantTeam, pointsDraw, vm.goalsVisitant, vm.goalsLocal);
				footballManager.addGame(idTournament, idLocalTeam, idVisistantTeam, vm.goalsLocal, vm.goalsVisitant);
			}else if(vm.goalsLocal < goalsVisitant){
				footballManager.updateTeamFromTournament(idTournament, idLocalTeam, pointsLost, vm.goalsLocal, vm.goalsVisitant);
				footballManager.updateTeamFromTournament(idTournament, idVisitantTeam, pointsWin, vm.goalsVisitant, vm.goalsLocal);
				footballManager.addGame(idTournament, idLocalTeam, idVisistantTeam, vm.goalsLocal, vm.goalsVisitant);
			}else{
				vm.error = true;
			};*/
		};
	};
	
	//SETTERS ------------------------
	
	vm.setGoalsLocal = function(goals){
		vm.goalsLocal = goals;
	};
	
	vm.setGoalsVisitant = function(goals){
		vm.goalsVisitant = goals;
	};
	
	vm.setTeamLocal = function(name){
		vm.teamLocal = name;
	};
	
	vm.setTeamVisitant = function(name){
		vm.teamVisitant = name;
	};
	
};