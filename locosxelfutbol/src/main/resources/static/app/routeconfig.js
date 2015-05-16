angular.module("app").config(RouteConfig);

RouteConfig.$inject = [ '$routeProvider' ];

function RouteConfig($routeProvider) {

	$routeProvider.when('/', { templateUrl : "templates/home.html" });
	$routeProvider.when('/newpost', { templateUrl : "templates/newpost.html" });
	$routeProvider.when('/post/:id', { templateUrl : "templates/post.html" });
	$routeProvider.when('/home', { templateUrl : "templates/home.html" });
	$routeProvider.when('/adminLogin', { templateUrl : "templates/adminLogin.html" });


}