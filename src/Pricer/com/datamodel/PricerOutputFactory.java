package Pricer.com.datamodel;
import org.jetbrains.annotations.NotNull;

public class PricerOutputFactory {

    public PricerOutputFactory(){}

    @NotNull
    public PricerOutput create(double myPrice) {
        return new PricerOutput(myPrice);
    }
}
