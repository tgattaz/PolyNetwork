angular.module('PolyNet',[]).controller('mainController', function ($scope, $http) {

    $scope.comment = {};

    $http.get('/liste').then(function callBack(response) {
        $scope.stories = response.data;
    });

    $scope.create = function () {
        var date = new Date();
        var task = {
            content : $scope.new_task,
            date : date
        };
        if($scope.new_task !== "") {
            $http.post('/create', task)
                .then(function success(response) {
                    $scope.new_task = '';
                    $scope.new_task.placeholder = 'A quoi tu penses câlisse ?';
                    $scope.stories = response.data;
                },function (data) {
                    console.log('Error: ' + data);
                })
        }

    };

    $scope.delete = function(id_task) {
        $http.post('/delete/', id_task)
            .then(function success(response) {
                $scope.stories = response.data;
            },function (data) {
                console.log('Error: ' + data);
            })
    };

    $scope.update = function(id_task, text) {
        console.log(id_task);
        console.log(text);
        $http.post('/update/' + id_task, text)
            .then(function success(response) {
                console.log(response.data);
                $scope.stories = response.data;
                $scope.update_text = "";
            },function (data) {
                console.log('Error: ');
                console.log(data);
            })
    };

    $scope.done = function(id_task) {
        $http.post('/done', id_task)
            .then(function success(response) {

                $scope.stories = response.data;
            },function (data) {
                console.log('Error: ' + data);
            })
    };

});