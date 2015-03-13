package Pricer.com.Pricer;

import Pricer.com.datamodel.BlackPricerInputs;
import Pricer.com.datamodel.BlackPricerOutput;
import Pricer.com.datamodel.PricerOutputFactory;
import org.jetbrains.annotations.NotNull;

class BlackPriceCalculator {

    @NotNull
    private final DOneCalculator theDOneCalculator;
    @NotNull
    private final DTwoCalculator theDTwoCalculator;
    @NotNull
    private final BlackPricerCore theBlackPricerCore;
    @NotNull
    private final PricerOutputFactory thePricerOutputFactory;

    BlackPriceCalculator(@NotNull DOneCalculator aDOneCalculator, @NotNull DTwoCalculator aDTwoCalculator,
                         @NotNull BlackPricerCore aBlackPricerCore, @NotNull PricerOutputFactory aPricerOutputFactory) {
        theDOneCalculator = aDOneCalculator;
        theDTwoCalculator = aDTwoCalculator;
        theBlackPricerCore = aBlackPricerCore;
        thePricerOutputFactory = aPricerOutputFactory;
    }

    @NotNull
    BlackPricerOutput calculate(@NotNull BlackPricerInputs aBlackPricerInputs) {
        double myVolatility = aBlackPricerInputs.getVolatility();
        double myVolaTimeToExpiry = aBlackPricerInputs.getVolaTimeToExpiry();
        double myDOne = theDOneCalculator.calculate(aBlackPricerInputs.getStrike(), aBlackPricerInputs.getForward(),
                myVolatility, myVolaTimeToExpiry);
        double myDTwo = theDTwoCalculator.calculate(myDOne, myVolatility, myVolaTimeToExpiry);
        double myPrice = theBlackPricerCore.calculatePrice(aBlackPricerInputs, myDOne, myDTwo);
        return thePricerOutputFactory.create(myPrice);
    }
}
