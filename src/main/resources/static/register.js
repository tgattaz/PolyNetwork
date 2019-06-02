angular.module('TchikiRegister', []).controller('userController',function($scope,$http){
    $scope.verif_password={};
    $scope.create_user = function(){
        var user = {
            username : $scope.username.text,
            password : $scope.password.text
        };
        console.log(user);
        document.getElementById("confirmation").textContent = "";
        document.getElementById("warning").textContent = "";
        if($scope.password.text === $scope.verif_password.text){
            $http({
                method: 'POST',
                url: '/register',
                data :user
            }).then(function successCallback() {
                document.getElementById("confirmation").textContent = "Confirmation de la création du compte, wesh alors !";
                setTimeout(function(){
                    window.location.replace('/');
                }, 5000);
            }, function errorCallback(response) {
                document.getElementById("warning").textContent = response.data.message;
            });
        }
        else{
            document.getElementById("warning").textContent = "Vos deux mots de passes sont différents, veuillez vérifier vos champs";
        }

    }
});