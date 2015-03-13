package Pricer.com.Pricer;

/**
* Created by Dread on 13/03/2015.
*/
class DiscountFactorCalculator {

    double calculate(double aInterestRate, double aVolaTimeToExpiry) {
        return Math.exp(-aInterestRate * aVolaTimeToExpiry);
    }

}
