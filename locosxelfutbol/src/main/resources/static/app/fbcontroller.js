angular.module("app").controller("FbController", FbController);

FbController.$inject = ["footballManager", "$timeout", "$location"];

function FbController(footballManager, $timeout, $location) {

	var vm = this;

	//Controller actions
	
	vm.reload= function(){
		vm.valido = footballManager.getValidouser();
	}
	
	setTimeout( function (){
		vm.reload();}
	,50000);	
	
	function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		window.location.assign("#/access");
		$location.path("/access");
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			window.location.assign("#/carrousel");
			//alert("hello");
			testAPI();
		} else if (response.status === 'not_authorized') {
			// The person is logged into Facebook, but not your app.
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this app.';
		} else {
			// The person is not logged into Facebook, so we're not sure if
			// they are logged into this app or not.
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into Facebook.';
		}
		//alert("hello2");
		window.location.assign("#/access");
		$location.path("/access");

	}

	// This function is called when someone finishes with the Login
	// Button. See the onlogin handler attached to it in the sample
	// code below.
	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '383555065168323',
			cookie : true, // enable cookies to allow the server to access
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v2.3' // use version 2.2
		});

		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
			if (response.status === 'connected') {
				vm.validouser= footballManager.setValidouser(true);
				window.location.assign("#/carrousel");
			}
		});

	};

	// Load the SDK asynchronously
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	// Here we run a very simple test of the Graph API after login is
	// successful. See statusChangeCallback() for when this call is made.
	function testAPI() {
		console.log('Welcome!  Fetching your information.... ');
		FB
				.api(
						'/me',
						function(response) {
							console.log('Successful login for: '
									+ response.name);
							document.getElementById('status').innerHTML = 'Thanks for logging in, '
									+ response.name + '!';
						});
		window.location.assign("#/access");
		$location.path("/access");	}
}