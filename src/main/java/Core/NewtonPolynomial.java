package Core;

import java.util.ArrayList;

/**
 * Class designed to Work with Newton Polynomial
 */
public class NewtonPolynomial {
    private double x[];
    private double y[];
    private int degree;
    private int iterator = 0;
    private String polynomialFormula = "";
    private ArrayList<Double> interpolation = new ArrayList<Double>();

    public NewtonPolynomial() {
        x = PropertyLoader.loadInitialValues('x');
        y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = calculateInitialY(x[i]);
        }

        degree = x.length;
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public String getPolynomialFormula() {
        createPolynomialFormula();
        return "L(" + degree + ") = " + y[0] + " + (x - " + x[0] + " )" + polynomialFormula;
    }

    public ArrayList<Double> getInterpolationValues() {
        calculateInterpolation();
        return interpolation;
    }

    public double calculatePolynomial(double x) {
        double result = 1;
        for (int i = degree - 1; i > -1; i--) {
            result *= (x - this.x[i]);
            result += y[i];
        }
        return result;
    }

    private double calculateInitialY(double x){
        return Math.cos(-2 * x) / 4;
    }

    private void calculateInterpolation() {
        double temp1 = y[0];
        double temp2;

        int k = 1;

        for (int i = 1; i < degree; i++) {
            for (int j = 0; j < degree - i; j++) {
                temp2 = y[j + k];
                //Calculate divided differences
                y[j + i] = (temp2 - temp1) / (x[j + i] - x[j]);
                interpolation.add(y[j + i]);

                temp1 = temp2;
            }
            k++;
            temp1 = y[i];
        }
    }

    private String createPolynomialFormula() {
        if (iterator < degree - 1) {
            iterator++;
            polynomialFormula = "(" + y[iterator] + " + (x - " + x[iterator] + ")" + createPolynomialFormula() + ")";

        }
        return polynomialFormula;
    }

    @Deprecated
    private void printPolynomial() {
        createPolynomialFormula();
        System.out.println("\nL(" + degree + ") = " + y[0] + " + (x - " + x[0] + " )" + polynomialFormula);
    }

    /**
     * Calculates Newton Polynomial and Print Table of divided differences + Polynomial formula.
     *
     * @param x - Value to calculate ny Newton Polynomial
     * @return Value calculated by Newton Polynomial
     */
    @Deprecated
    public double calculate(double x) {
        calculateInterpolation();
        printPolynomial();
        return calculatePolynomial(x);
    }

}
