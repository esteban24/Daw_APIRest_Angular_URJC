angular.module("app").controller("PlayerController", PlayerController);

PlayerController.$inject = ["footballManager", "$timeout", "$location"];

function PlayerController(footballManager, $timeout, $location) {

	var vm = this;
	
	vm.players= footballManager.getPlayers();
	vm.player={};
	vm.modifyPlayer=footballManager.modifyPlayer;
	vm.valido = footballManager.getValido();

	//Controller actions
	
	vm.reload= function(){
		footballManager.reload();
		vm.players=footballManager.players;
	}
	
	setTimeout( function (){
		vm.reload();}
	,500);
	
	/*ojooooooo*/vm.modify4 = function(player){
		vm.modifyPlayer=footballManager.setModifyPlayer(player);
		vm.reload();
		$location.path('/modifyPlayer');
	}
	
	vm.modifyingplayer= function(player){
		footballManager.modifyingplayer(player);
		vm.modifyPlayer={};
		footballManager.setModifyPlayer(vm.modifyPlayer);
		vm.reload();
		$location.path('/playerAdmin');
	}
	
	vm.deletePlayer = function(player){
		footballManager.deletePlayer(player);
		vm.player={};
		vm.reload();
		$location.path('/playerAdmin');
	}
};