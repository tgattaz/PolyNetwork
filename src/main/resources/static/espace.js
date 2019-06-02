angular.module('PolyNet',[]).controller('mainController', function ($scope, $http) {

    $scope.comment = {};

    $http.get('/liste').then(function callBack(response) {
        $scope.stories = response.data;
        console.log(response);
    })

    $scope.add_story = function () {
        console.log($scope.data_to_add);
        $http.post('/story', $scope.data_to_add)
            .then(function () {
                $scope.data_to_add='';
                $http.get('/liste').then(function (response) {
                    $scope.stories = response.data;
                })
            },function (data) {

                console.log('Error: ' + data);
            })

    };

    $scope.add_comment = function (id, content) {
        $scope.comment.content = content;
        $scope.comment.identifiant = id;
        console.log($scope.comment);
        $http.post('/comment', $scope.comment)
            .then(function () {
                $scope.comment_to_add='';
                $http.get('/liste').then(function (response) {
                    $scope.stories = response.data;
                })

            },function (data) {

                console.log('Error: ' + data);
            })
    };

    $scope.see_com = function (id) {
        if (document.getElementById('commentaires_'+id).style.display == "none"){
            document.getElementById('label_com_'+id).innerHTML = "Cacher les critiques obvious des rageux";
            document.getElementById('commentaires_'+id).style.display = "block";
        } else {
            document.getElementById('label_com_'+id).innerHTML = "Mater les critiques obvious des rageux";
            document.getElementById('commentaires_'+id).style.display = "none";
        };

    };
});