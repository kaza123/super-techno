(function () {
    //index module
    angular.module("AppModule", [
        "ngRoute",
        "ngAnimate",
        "ngCookies",
        "ui.bootstrap",
        "ui-notification",
        "homeModule",
        "chart.js"
    ]);

    //constants
    angular.module("AppModule")
            .constant("systemConfig", {
                apiUrl:
                        location.hostname === 'localhost'
                        ? "http://localhost:8076"
                        : location.protocol + "//" + location.hostname + (location.port ? ':' + location.port : '')
            });

    //route config
    angular.module("AppModule")
            .config(function ($routeProvider) {
                $routeProvider
                        //system
                        .when("/", {
                            templateUrl: "app/super-techno/system/login.html",
                            controller: "LoginController"
                        })
//                        .when("/sms_discount", {
//                            templateUrl: "app/master/sms_discount/sms_discount.html",
//                            controller: "SmsDiscountController"
//                        })
//                        .when("/loyalty_customer", {
//                            templateUrl: "app/master/loyalty_customer/loyalty_customer.html",
//                            controller: "LoyaltyCustomerController"
//                        })
//                        .when("/loyalty_customer_update", {
//                            templateUrl: "app/master/loyalty_customer_update/loyalty_customer_update.html",
//                            controller: "LoyaltyUpdateController"
//                        })
//                        .when("/plant", {
//                            templateUrl: "app/master/plant/plant.html",
//                            controller: "PlantController"
//                        })
//                        .when("/calender", {
//                            templateUrl: "app/master/calender/calender.html",
//                            controller: "CalenterController"
//                        })
                        .when("/home", {
                            templateUrl: "app/super-techno/home/home.html"
                        })
                        .when("/main", {
                            templateUrl: "app/super-techno/main/main.html",
                            controller: "mainController"
                        })
                        .otherwise({
                            redirectTo: "/"
                        });
            });
//    angular.module("AppModule")
//            .run(function ($rootScope, $location, $cookieStore, $http) {
//                // keep user logged in after page refresh
//                $rootScope.globals = $cookieStore.get('globals') || {};
//                if ($rootScope.globals.currentUser) {
//                    $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
//                }
//
//                $rootScope.$on('$locationChangeStart', function (event, next, current) {
//                    // redirect to login page if not logged in
//                    if ($location.path() !== '/' && !$rootScope.globals.currentUser) {
//                        $location.path('/');
//                    }
//                });
//            });

    angular.module("AppModule")
            .controller("IndexController", function ($scope, $rootScope, $timeout, Factory,$cookieStore, $location) {
                $rootScope.model = {};
                $rootScope.level = {};
                $scope.ui = {};
                $scope.model.user = {};
                $rootScope.model.map = [];
                $scope.globals={};


                $scope.ui.logout = function () {
                    $rootScope.value = null;
                    $rootScope.globals = {};
                    $location.path("/");
                };
                $scope.ui.CliclLevel1 = function (name) {
                    $rootScope.level.one = name;
                    $rootScope.level.two = '';
                };
                $scope.ui.CliclLevel2 = function (name) {
                    $rootScope.level.two = name;
                };

                $scope.ui.init = function () {
//                    $rootScope.level.one='Home';
                    $scope.globals = $cookieStore.get('globals');
                    console.log('app.js');
                    console.log($scope.globals);
                };
                $scope.ui.init();
            });
}());