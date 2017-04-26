package Core;

/**
 * Created by shepelsky on 26.04.2017.
 */
public class TheoreticalError {

    private double beginningInterval = Math.PI / 4;
    private double endingInterval = Math.PI;
    private int n = 5;
    private double step = (endingInterval - beginningInterval) / n;

    public double getTheoreticalError(double x) {
        return calculateMaximum() * calculateW(x);
    }

    private double calculateW(double x) {
        double result = 1;

        for(int i=0; i<=n; i++ ){
            result *= (x - (beginningInterval + step * i) ) / (i + 1);
        }

        return result;
    }

    private double calculateMaximum() {
        double maximum = -16 * Math.cos(-2 * beginningInterval);
        double tmp;
        for (double i = beginningInterval; i < endingInterval; i += 0.01) {
            tmp = -16 * Math.cos(-2 * i);
            if (tmp > maximum)
                maximum = tmp;
        }
        return maximum;
    }


}
