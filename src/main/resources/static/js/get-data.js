angular.module('general-data', [])
    .controller('home', function($scope, $http) {
        $http.get('/').success(function(data) {
            $scope.model = data;
            var X= data.x;
            var Y = data.y;
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

        });

        $scope.getX =  function() {
            $http({
                method: 'GET',
                url: "/api/" + $scope.x
           }).success(function(data) {
               $scope.xData = data;

               //out errors


           });
        };
    })