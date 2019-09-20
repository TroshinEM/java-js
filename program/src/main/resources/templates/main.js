var app =angular.module('equipment', [])
app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);

 app.controller('eqCtrl', function($scope, $http) {
        $scope.SendData = function(model_input, serial_input){
            $http({
                    url: 'http://localhost:8080/equipment/add',
                    dataType: 'json',
                    method: 'POST',
                    data : {model: model_input,
                        serial: serial_input },
            })
        };

        $scope.DeleteData = function(id_input){
            $http({
                    url: 'http://localhost:8080/equipment/delete',
                    dataType: 'json',
                    method: 'POST',
                    data : {id: id_input }
            })
         };

        $scope.UpdateModel = function(id_input, model_input){
           $http({
                    url: 'http://localhost:8080/equipment/update_model',
                    dataType: 'json',
                    method: 'POST',
                    data : {id: id_input,
                        model: model_input },
            })
        };

        $scope.UpdateSerial = function(id_input, serial_input){
           $http({
                    url: 'http://localhost:8080/equipment/update_serial',
                    dataType: 'json',
                    method: 'POST',
                    data : {id: id_input,
                        serial: serial_input },
            })
        };

        $scope.ShowAll =function(){
            document.location.href = 'http://localhost:8080/equipment/all';
        }
});




