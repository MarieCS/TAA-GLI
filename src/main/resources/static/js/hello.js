var app = angular.module('hello', []);

app.controller('menu',function($scope, $http, $log) {
    $scope.userPage = function(){
        console.log("coucou");
    }
});

app.controller('home', function($scope, $http, $log) {
    $scope.greeting = {id: 'toto', content: 'Hello World!'}
    
    
    $http({
        method : "GET",
        url : "http://localhost:8080//user/get-all"
    }).then(function mySuccess(response) {
        $scope.users = response.data;
    }, function myError(response) {
        $scope.users = response.statusText;
    });
    
    $http({
        method : "GET",
        url : "http://localhost:8080//sport/get-all"
    }).then(function mySuccess(response) {
        $scope.sports = response.data;
    }, function myError(response) {
        $scope.sports = response.statusText;
    });

    
    $scope.addToto = function() {        
        
        var data = {
                email: "toto@mail.com",
                name: "toto"
            };//"name=toto,email=toto@mail.com";/*
        
            var config = {
                headers : {
                    'Content-Type': 'Content-Type: multipart/form-data;'
                }
            }
            console.log($scope.users);
            console.log(data);
            $http.put('http://localhost:8080//user/create', data, config)
            .success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    }
    $scope.addSportVelo = function() {  
       // console.log($scope.sports);
       var nameVelo = "velo";
        var data = {            
            name: 'nameVelo'
            };
        
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            
            
            $http.put('http://localhost:8080//sport/create', data, config)
            .success(function (data, status, headers, config) {
                $scope.PostDataResponse = data;
            })
            .error(function (data, status, header, config) {
                $scope.ResponseDetails = "Data: " + data +
                    "<hr />status: " + status +
                    "<hr />headers: " + header +
                    "<hr />config: " + config;
            });
    }
});