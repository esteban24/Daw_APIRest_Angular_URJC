angular.module("app").controller("SecurityController", SecurityController);

SecurityController.$inject = ["footballManager","$location", "$http"];

function SecurityController(footballManager, $location, $http) {

	var vm = this;
	
	vm.mail="";
	vm.mailuser="";
	vm.pass="";
	vm.passuser="";
	vm.login= footballManager.login();
	vm.loginuser= footballManager.loginuser();
	vm.valido=footballManager.getValido();
	vm.validouser=footballManager.getValidouser();
	
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
	
	vm.loginuser = function() {
		footballManager.loginuser(vm.mailuser,vm.passuser, function(validouser){
			if(validouser){
				footballManager.setValidouser(true);
				$location.path("/carrousel");		
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