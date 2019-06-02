angular.module('TchikiRegister', []).controller('userController',function($scope,$http){
    $scope.verif_password={};
    $scope.create_user = function(){
        var user = {
            username : $scope.username.text,
            password : $scope.password.text
        };
        console.log(user);
        if($scope.password.text === $scope.verif_password.text){
            $http({
                method: 'POST',
                url: '/register',
                data :user
            }).then(function successCallback() {
                window.location.href="/"
            }, function errorCallback(response) {
                alert(response.data.message)
            });
        }
        else {
            alert("Vos deux mots de passes sont différents, veuillez vérifier vos champs")
        }

    }
});