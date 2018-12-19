(function () {
    'use strict';

    //-----------http controller---------
    angular.module("AppModule")
            .controller("LoginController", function ($http, systemConfig, Factory, $scope, $rootScope, $location, AuthenticationService, $cookieStore, Notification) {
                //ui models
                $scope.ui = {};
                $scope.ui.branchList = [
                    {indexNo: 1, name: 'Super Techno'},
                    {indexNo: 2, name: 'Auto Reborn'}
                ];
//                $rootScope.branch=1;

                $scope.ui.branchLable = function (index) {
                    var lable = "";
                    angular.forEach($scope.ui.branchList, function (branch) {
                        if (branch.indexNo === parseInt(index)) {
                            lable = branch.indexNo + ' - ' + branch.name;
                            return;
                        }
                    });
                    return lable;
                };

                // reset login status
                AuthenticationService.ClearCredentials();

                $scope.login = function () {
                    AuthenticationService.Login($scope.username, $scope.password, $scope.branch, function (response) {
                        console.log(response);
                        if (response) {
                            AuthenticationService.SetCredentials($scope.username, $scope.password, response.type, response.indexNo, $scope.branch);
                            $rootScope.user = response;

                            $cookieStore.put('globals', $rootScope.globals);

//                           
                            $location.path('/home');
                            $rootScope.level.one = 'Home';
                        } else {
                            $rootScope.error('wrong Password!');
                        }
                    });
                };

            });
}());
