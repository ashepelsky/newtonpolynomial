/**
 * Created by ashepelsky on 4/11/2017.
 */
public class NewtonPolynomial {
    private double x[] = PropertyLoader.loadInitialValues('x');
    private double y[] = PropertyLoader.loadInitialValues('y');
    private int degree = x.length;

    //TODO: Refactor method
    private void calculateInterpolation() {
        double temp1 = y[0];
        double temp2 = y[1];

        int k = 2;

        for (int i = 1; i < degree; i++) {
            for (int j = 0; j < degree - i; j++) {

                y[j + i] = (temp2 - temp1) / (x[j + i] - x[j]);
                //System.out.println((x[j + i] - x[j]));
                temp1 = temp2;
                try {
                    temp2 = y[j + k];
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
            k++;
            temp1 = y[i];
            try {
                temp2 = y[i + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        //System.out.println("test");

    }

    private double calculatePolynomial(double x) {
        double result = 1;
        for (int i = degree - 1; i > -1; i--) {
            result*= y[i] + (x - this.x[i]);
        }
        return result;
    }

    public double calculate(double x) {
        calculateInterpolation();
        return calculatePolynomial(x);
    }

}
