angular.module('stringhandler', []).controller('stringController', function ($scope, $http) {


    $scope.handledString = function () {
        if ($scope.str == null) {
            alert('Please write a correct string');
        } else {
            $http.post('http://localhost:8080/stringhandler/api/v1/string', $scope.str)
                .then(function (response) {
                    console.log(response.data);
                    let newResult = [];

                    for (let key in response.data) {
                        newResult.push(key + ': ' + response.data[key]);
                    }
                    $scope.str = null;
                    $scope.result = newResult;
                });
        }
    }

});