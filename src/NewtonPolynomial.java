/**
 * Created by ashepelsky on 4/11/2017.
 */
public class NewtonPolynomial {
    private double x[] = PropertyLoader.loadInitialValues('x');
    private double y[] = PropertyLoader.loadInitialValues('y');
    private int degree = x.length;

    private void calculateInterpolation() {
        double temp1 = y[0];
        double temp2;

        int k = 1;

        for (int i = 1; i < degree; i++) {
            for (int j = 0; j < degree - i; j++) {
                temp2 = y[j + k];
                y[j + i] = (temp2 - temp1) / (x[j + i] - x[j]);
                System.out.print(y[j + i] + " \t");

                temp1 = temp2;
            }
            System.out.println(" ");
            k++;
            temp1 = y[i];
        }
    }

    private double calculatePolynomial(double x) {
        double result = 1;
        for (int i = degree - 1; i > -1; i--) {
            result *= y[i] + (x - this.x[i]);
        }
        return result;
    }

    private void printFormula() {
    }

    public double calculate(double x) {
        calculateInterpolation();
        printFormula();
        return calculatePolynomial(x);
    }

}
