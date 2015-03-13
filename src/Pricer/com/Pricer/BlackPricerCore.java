package Pricer.com.Pricer;

import Pricer.com.datamodel.OptionKind;
import Pricer.com.datamodel.BlackPricerInputs;
import org.jetbrains.annotations.NotNull;

class BlackPricerCore {

    @NotNull
    private final DiscountFactorCalculator theDiscountFactorCalculator;
    @NotNull
    private final CallPriceCalculator theCallPriceCalculator;
    @NotNull
    private final PutPriceCalculator thePutPriceCalculator;

    BlackPricerCore(@NotNull DiscountFactorCalculator aDiscountFactorCalculator,
                    @NotNull CallPriceCalculator aCallPriceCalculator,
                    @NotNull PutPriceCalculator aPutPriceCalculator) {
        theDiscountFactorCalculator = aDiscountFactorCalculator;
        theCallPriceCalculator = aCallPriceCalculator;
        thePutPriceCalculator = aPutPriceCalculator;
    }

    double calculatePrice(BlackPricerInputs aPricerInput, double aDOne, double aDTwo) {
        double thePrice;
        double myDiscountFactor = theDiscountFactorCalculator.calculate(aPricerInput.getTheInterestRate(),
                aPricerInput.getVolaTimeToExpiry());
        if (aPricerInput.getOptionKind() == OptionKind.CALL) {
            thePrice = theCallPriceCalculator.calculate(aPricerInput.getForward(), aPricerInput.getStrike(), aDOne,
                    aDTwo, myDiscountFactor);
        } else {
            thePrice = thePutPriceCalculator.calculate(aPricerInput.getForward(), aPricerInput.getStrike(), aDOne,
                    aDTwo, myDiscountFactor);
        }
        return thePrice;
    }

}
