package Pricer.com.Pricer;

class DiscountFactorCalculator {

    double calculate(double aInterestRate, double aVolaTimeToExpiry) {
        return Math.exp(-aInterestRate * aVolaTimeToExpiry);
    }

}
