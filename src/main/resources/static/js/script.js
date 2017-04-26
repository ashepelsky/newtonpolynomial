function differencesLoad(model){
    var columnNumber = countColumns(model);
}

function countColumns(model){
    var colNumber=1;
    var counter=0;
    model.interpolation.forEach(function solve() {
        counter++;
        if(counter>colNumber) {
            colNumber++;
            counter=1;
        }
    }
    );
    return colNumber;
}

function countFunction(x){
    return (1/4)*Math.cos(-2*x);
}

