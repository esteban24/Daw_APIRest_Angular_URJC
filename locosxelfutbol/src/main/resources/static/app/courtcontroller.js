angular.module("app").controller("CourtController", CourtController);

CourtController.$inject = ["footballManager", "$timeout", "$location"];

function CourtController(footballManager, $timeout, $location) {

	var vm = this;
	vm.courts= footballManager.getCourts();
	vm.court={};
	vm.modifyCourt=footballManager.modifyCourt;
	vm.valido = footballManager.getValido();
	vm.validouser= footballManager.getValidouser();

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.courts=footballManager.courts;
		vm.valido = footballManager.getValido();
	}
	
	setTimeout( function (){
		vm.reload();}
	,50000);		
	
	/*ojooooooo*/vm.modify2 = function(court){
		vm.modifyCourt=footballManager.setModifyCourt(court);
		vm.reload();
		$location.path('/modifyCourt');
	}
	
	vm.logout = function() {
		footballManager.logout();
		$location.path("/");
	};
	
	vm.addCourt= function(court){
		footballManager.addCourt(court);
		vm.court={};
		vm.reload();
		$location.path('/courtAdmin');
	}
	
	vm.modifyingcourt= function(court){
		footballManager.modifyingcourt(court);
		vm.modifyCourt={};
		footballManager.setModifyCourt(vm.modifyCourt);
		vm.reload();
		$location.path('/courtAdmin');
	}
	
	vm.deleteCourt = function(court){
		footballManager.deleteCourt(court);
		vm.court={};
		vm.reload();
		$location.path('/courtAdmin');
	}
};