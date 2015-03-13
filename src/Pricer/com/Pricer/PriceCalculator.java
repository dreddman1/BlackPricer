package Pricer.com.Pricer;

import Pricer.com.datamodel.OptionKind;
import Pricer.com.datamodel.PricerInputs;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.jetbrains.annotations.NotNull;

/**
* Created by Dread on 13/03/2015.
*/
class PriceCalculator {

    @NotNull
    private final NormalDistribution theNormalDistribution;
    @NotNull
    private final DiscountFactorCalculator theDiscountFactorCalculator;
    @NotNull
    private final CallPriceCalculator theCallPriceCalculator;

    PriceCalculator(@NotNull NormalDistribution aNormalDistribution,
                    @NotNull DiscountFactorCalculator aDiscountFactorCalculator,
                    @NotNull CallPriceCalculator aCallPriceCalculator) {
        theNormalDistribution = aNormalDistribution;
        theDiscountFactorCalculator = aDiscountFactorCalculator;
        theCallPriceCalculator = aCallPriceCalculator;
    }

    double calculatePrice(PricerInputs aPricerInput, double aDOne, double aDTwo) {
        double thePrice;
        double myDiscountFactor = theDiscountFactorCalculator.calculate(aPricerInput.getTheInterestRate(),
                aPricerInput.getVolaTimeToExpiry());
        if (aPricerInput.getOptionKind() == OptionKind.CALL) {
            thePrice = myDiscountFactor * theCallPriceCalculator.calculate(aPricerInput.getForward(), aPricerInput.getStrike(), aDOne,
                    aDTwo);
        } else {
            thePrice = myDiscountFactor * (aPricerInput.getStrike() *
                    theNormalDistribution.cumulativeProbability(-aDTwo) -
                    aPricerInput.getForward() * theNormalDistribution.cumulativeProbability(-aDOne));
        }
        return thePrice;
    }

}
