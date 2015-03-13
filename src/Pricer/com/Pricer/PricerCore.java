package Pricer.com.Pricer;

import Pricer.com.datamodel.PricerInputs;
import Pricer.com.datamodel.PricerOutput;
import Pricer.com.datamodel.PricerOutputFactory;
import org.jetbrains.annotations.NotNull;

class PricerCore {

    @NotNull
    private final DOneCalculator theDOneCalculator;
    @NotNull
    private final DTwoCalculator theDTwoCalculator;
    @NotNull
    private final PriceCalculator thePriceCalculator;
    @NotNull
    private final PricerOutputFactory thePricerOutputFactory;

    PricerCore(@NotNull DOneCalculator aDOneCalculator, @NotNull DTwoCalculator aDTwoCalculator,
               @NotNull PriceCalculator aPriceCalculator, @NotNull PricerOutputFactory aPricerOutputFactory) {
        theDOneCalculator = aDOneCalculator;
        theDTwoCalculator = aDTwoCalculator;
        thePriceCalculator = aPriceCalculator;
        thePricerOutputFactory = aPricerOutputFactory;
    }

    @NotNull
    PricerOutput calculate(@NotNull PricerInputs aPricerInputs) {
        double myVolatility = aPricerInputs.getVolatility();
        double myVolaTimeToExpiry = aPricerInputs.getVolaTimeToExpiry();
        double myDOne = theDOneCalculator.calculate(aPricerInputs.getStrike(), aPricerInputs.getForward(),
                myVolatility, myVolaTimeToExpiry);
        double myDTwo = theDTwoCalculator.calculate(myDOne, myVolatility, myVolaTimeToExpiry);
        double myPrice = thePriceCalculator.calculatePrice(aPricerInputs, myDOne, myDTwo);
        return thePricerOutputFactory.create(myPrice);
    }
}
