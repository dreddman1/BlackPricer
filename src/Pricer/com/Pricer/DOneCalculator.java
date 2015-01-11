package Pricer.com.Pricer;

class DOneCalculator {

    private static final double EPSILON = 1E-10;

    double calculate(double aStrike, double aForward, double aVolatility, double aVolaTimeToExpiry) {
        double myNumerator = Math.log(aForward / aStrike) + (aVolatility * aVolatility / 2) * aVolaTimeToExpiry;
        double myDenominator = aVolatility * Math.sqrt(aVolaTimeToExpiry);
        return myNumerator / Math.max(myDenominator, EPSILON);
    }

}
