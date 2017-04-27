angular.module('general-data', [])
    .controller('home', function($scope, $http) {
        $http.get('/').success(function(response) {
            $scope.model = response;
            var X = response.x;
            var Y = response.y;
            var func = {
                x: X,
                y: Y,
                mode: 'scatter'
            };
            var layout={
                title: "Function Graphic"
            };
            var data = [func];
            Plotly.newPlot('plot-area', data, layout);

            //#####


        });

        $scope.getX =  function() {
            $http({
                method: 'GET',
                url: "/api/" + $scope.x
           }).success(function(response) {
               $scope.xData = response;

               $scope.xData.functionValue = Math.cos(-2*$scope.x)/4;
               $scope.xData.partialError = Math.abs($scope.xData.theoreticalError)

               //out errors


           });
        };
    })