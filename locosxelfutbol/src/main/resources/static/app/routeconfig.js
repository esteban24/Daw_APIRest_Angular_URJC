angular.module("app").config(RouteConfig);

RouteConfig.$inject = [ '$routeProvider' ];

function RouteConfig($routeProvider) {

	$routeProvider.when('/', { templateUrl : "templates/home.html" });
	$routeProvider.when('/home', { templateUrl : "templates/home.html" });
	$routeProvider.when('/adminLogin', { templateUrl : "templates/adminLogin.html" });
	$routeProvider.when('/team', { templateUrl : "templates/team.html" });
	$routeProvider.when('/referee', { templateUrl : "templates/referee.html" });

}