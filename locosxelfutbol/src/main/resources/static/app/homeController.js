angular.module("app").factory("adminController", adminController);

adminController.java.$inject = [ "$resource", "$timeout" ];

function adminController($resource, $timeout) {

	function autoreload(){
		reload();
		$timeout(autoreload, 5000);
	}
	
	autoreload();
	
	return {
		reload : reload,
	}

	function reload(){
		var promise = PostResource.query(function(newposts){
			posts.length = 0;
			posts.push.apply(posts, newposts);
		}).$promise;
		return promise;
	}
	
}