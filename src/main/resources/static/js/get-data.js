angular.module('general-data', [])
    .controller('home', function($scope, $http) {
        $http.get('/').success(function(data) {
            $scope.model = data;
        })

        $scope.drawPlot = function() {
            var X=[1,2,3.1,5];
            var Y = [-10, 15, 13, 17];
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
        }
    });