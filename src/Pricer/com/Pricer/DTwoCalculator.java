package Pricer.com.Pricer;

/**
* Created by Dread on 13/04/2014.
*/
class DTwoCalculator {

    double calculate(double aDOne, double aVolatility, double aVolaTimeToExpiry){
        return aDOne - aVolatility * Math.sqrt(aVolaTimeToExpiry);
    }
}
