package Pricer.com.datamodel;
import org.jetbrains.annotations.NotNull;

public class PricerOutputFactory {

    @NotNull
    public BlackPricerOutput create(double myPrice) {
        return new BlackPricerOutput(myPrice);
    }
}
