package Pricer.com.datamodel;

public class PricerOutput {

    private final double thePrice;

    PricerOutput(double aPrice) {
        thePrice = aPrice;
    }

    double getThePrice() {
        return thePrice;
    }
}
