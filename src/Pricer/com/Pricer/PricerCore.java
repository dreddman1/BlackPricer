package Pricer.com.Pricer;

import Pricer.com.datamodel.PricerInputs;
import Pricer.com.datamodel.PricerOutput;
import org.jetbrains.annotations.NotNull;

class PricerCore {

    @NotNull
    private final DOneCalculator theDOneCalculator;
    @NotNull
    private final DTwoCalculator theDTwoCalculator;

    PricerCore(@NotNull DOneCalculator aDOneCalculator, @NotNull DTwoCalculator aDTwoCalculator) {
        theDOneCalculator = aDOneCalculator;
        theDTwoCalculator = aDTwoCalculator;
    }

    @NotNull
    PricerOutput calculate(@NotNull PricerInputs aPricerInputs) {
        double myVolatility = aPricerInputs.getVolatility();
        double myVolaTimeToExpiry = aPricerInputs.getVolaTimeToExpiry();
        double myDOne = theDOneCalculator.calculate(aPricerInputs.getStrike(), aPricerInputs.getForward(),
                myVolatility, myVolaTimeToExpiry);
        double myDTwo = theDTwoCalculator.calculate(myDOne, myVolatility, myVolaTimeToExpiry);

    }
}
