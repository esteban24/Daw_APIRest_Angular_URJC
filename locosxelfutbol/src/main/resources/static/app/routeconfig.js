angular.module("app").config(RouteConfig);

RouteConfig.$inject = [ '$routeProvider' ];

function RouteConfig($routeProvider) {

	$routeProvider.when('/', { templateUrl : "templates/carrousel.html" });
	$routeProvider.when('/home', { templateUrl : "templates/home.html" });
	$routeProvider.when('/carrousel', { templateUrl : "templates/carrousel.html" });
	$routeProvider.when('/adminLogin', { templateUrl : "templates/adminLogin.html" });
	$routeProvider.when('/team', { templateUrl : "templates/team.html" });
	$routeProvider.when('/referee', { templateUrl : "templates/referee.html" });
	$routeProvider.when('/refereeAdmin', { templateUrl : "templates/refereeAdmin.html" });
	$routeProvider.when('/addReferee', { templateUrl : "templates/addReferee.html" });
	$routeProvider.when('/tournament', { templateUrl : "templates/tournament.html" });
	$routeProvider.when('/tournamentAdmin', { templateUrl : "templates/tournamentAdmin.html" });
	$routeProvider.when('/player', { templateUrl : "templates/player.html" });
	
	$routeProvider.when('/court', { templateUrl : "templates/court.html" });
	$routeProvider.when('/courtAdmin', { templateUrl : "templates/courtAdmin.html" });
	$routeProvider.when('/addCourt', { templateUrl : "templates/addCourt.html" });
	$routeProvider.when('/modifyCourt', { templateUrl : "templates/modifyCourt.html" });
	
	$routeProvider.when('/modifyReferee', { templateUrl : "templates/modifyReferee.html" });
	


}