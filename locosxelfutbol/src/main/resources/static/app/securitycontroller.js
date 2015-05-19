angular.module("app").controller("SecurityController", SecurityController);

SecurityController.$inject = ["footballManager","$location"];

function SecurityController(footballManager, $location) {

	var vm = this;
	
	//View model properties
	//vm.personas = globalService.getPersonas();
	//vm.persona=globalService.getPersona();
	vm.mail="";
	vm.maillog="";
	vm.pass="";
	vm.passlog="";
	vm.islog=footballManager.islog();
	
	//Controller actions
	vm.login = function() {
		var valido=footballManager.login(vm.maillog,vm.passlog);
		setTimeout(function(){$location.path("/adminLogin");},1000);
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