angular.module("app").config(RouteConfig);

RouteConfig.$inject = [ '$routeProvider' ];

function RouteConfig($routeProvider) {

	$routeProvider.when('/', { templateUrl : "templates/mainMenu.html" });
	$routeProvider.when('/newpost', { templateUrl : "templates/newpost.html" });
	$routeProvider.when('/post/:id', { templateUrl : "templates/post.html" });
	//TODO emartin: Crear los paths a las distintas páginas de nuestra aplicació
	$routeProvider.when('/home', { templateUrl : "templates/mainMenu.html" });
	$routeProvider.when('/adminLogin', { templateUrl : "templates/adminLogin.html" });


}