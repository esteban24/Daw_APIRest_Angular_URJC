angular.module("app").controller("SecurityController", SecurityController);

SecurityController.$inject = ["footballManager","$location", "$http"];

function SecurityController(footballManager, $location, $http) {

	var vm = this;
	
	//View model properties
	//vm.personas = globalService.getPersonas();
	//vm.persona=globalService.getPersona();
	vm.mail="";
	vm.maillog="";
	vm.pass="";
	vm.passlog="";
	vm.login= footballManager.login();
	vm.valido=footballManager.getValido();
	
	//Controller actions
	vm.login = function() {
		footballManager.login(vm.mail,vm.pass, function(valido){
			if(valido){
				footballManager.setValido(true);
				$location.path("/adminLogin");		
			} else {
				$location.path("/error");
			}
		});
	};
	vm.logout = function() {
		footballManager.logout();
		$location.path("/#");
	};
	vm.signup = function(){
		footballManager.signup(vm.mail,vm.pass);
		$location.path("/");
	}
};