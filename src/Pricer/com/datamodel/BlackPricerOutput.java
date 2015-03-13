package Pricer.com.datamodel;

public class BlackPricerOutput {

    private final double thePrice;

    public BlackPricerOutput(double aPrice){
      thePrice = aPrice;
    }

    public double getPrice() {
        return thePrice;
    }
}
