'use strict';

angular.module("AppModule")
        .config(function ($httpProvider) {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            $httpProvider.defaults.withCredentials = true;
        });

angular.module('AppModule')
        .factory('AuthenticationService', function (systemConfig, $http, $cookieStore, $rootScope, $timeout) {
            var service = {};

            $rootScope.model = {
                name: null,
                password: null
            };

            service.Login = function (username, password, branch, callback) {

                /* Use this for real authentication
                 ----------------------------------------------*/
                $rootScope.model.name = username;
                $rootScope.model.password = password;
                $rootScope.model.branch = branch;

//                var auth = username + '--' + password + ":" + password;
                var auth = username + "#" + password + "#" + branch + ":" + password;
                auth = "Basic " + btoa(auth);
                console.log("auth " + auth);
                console.log(username, password);
                var headers = {
                    "Authorization": auth,
                    "X-Requested-With": "XMLHttpRequest"
//                    "Access-Control-Allow-Origin": "*"
                };
                console.log(headers);
                console.log(headers);
                console.log(headers);
                var url = systemConfig.apiUrl + "/security/login";

                console.log(url);
                var DetailJSON = JSON.stringify($rootScope.model);
                $http.post(url, DetailJSON, {
                    'headers': headers
                })
                        .success(function (response) {
                            console.log(response);
                            callback(response);
                        })
                        .error(function (data) {
                            $rootScope.error = 'username or password is incorrect';
                            console.log(data);
                        });
                ;
            };

            service.SetCredentials = function (username, password, type, indexno, branch) {
                var authdata = btoa(username + "#" + password + "#" + branch  + ":" + password); //$base64.encode(username + ':' + password);

                $rootScope.globals = {
                    currentUser: {
                        username: username,
                        authdata: authdata,
                        type: type,
                        indexNo: indexno,
                        branch: branch
                    }
                };

                $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
                $cookieStore.put('globals', $rootScope.globals);
            };

            service.ClearCredentials = function () {
                $rootScope.globals = {};
                $cookieStore.remove('globals');
                $http.defaults.headers.common.Authorization = 'Basic ';
            };

            return service;
        });
