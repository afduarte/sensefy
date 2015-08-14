angular.module('auth', []).factory(
		'auth',

		function($rootScope, $http, $location) {

			enter = function() {
				if ($location.path() != auth.loginPath) {
					auth.path = $location.path();
					if (!auth.authenticated) {
						$location.path(auth.loginPath);
					}
				}					
			}

			var auth = {

				authenticated : false,

				loginPath : '/login',
				logoutPath : '/logout',
				homePath : '/',
                searchPath: '/search',
				path : $location.path(),

				authenticate : function(credentials, callback) {

					var headers = credentials && credentials.username ? {
						authorization : "Basic "
								+ btoa(credentials.username + ":"
										+ credentials.password)
					} : {};

					$http.get('user', {
						headers : headers
					}).success(function(data) {
						if (data.name) {
							auth.authenticated = true;
						} else {
							auth.authenticated = false;
						}
						callback && callback(auth.authenticated);
                    $location.path(auth.path==auth.loginPath ? auth.homePath : auth.path);
                    console.log(auth.path +' = '+ auth.loginPath)
						$location.path(auth.path==auth.loginPath ? auth.homePath : auth.searchPath);
					}).error(function() {
						auth.authenticated = false;
				   	callback && callback(false);
					});

				},

				clear : function() {
					
					auth.authenticated = false;

					$location.path(auth.logoutPath).replace();
					$location.path(auth.loginPath);
//					$http.get(auth.logoutPath, {}).success(function() {
//						console.log("Logout succeeded");
//					}).error(function(data) {
//						console.log("Logout failed");
//					});
//					$location.path(auth.logoutPath).reload();
				},

				init : function(homePath, loginPath, logoutPath) {

					auth.homePath = homePath;
					auth.loginPath = loginPath;
					auth.logoutPath = logoutPath;

					auth.authenticate({}, function(authenticated) {
						if (authenticated) {
							$location.path(auth.path);
						}
					})

					// Guard route changes and switch to login page if unauthenticated
					$rootScope.$on('$routeChangeStart', function() {
						enter();
					});

				}

			};

			return auth;

		});
