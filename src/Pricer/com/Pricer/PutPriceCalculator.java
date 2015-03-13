package Pricer.com.Pricer;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.jetbrains.annotations.NotNull;

class PutPriceCalculator {

    @NotNull
    private final NormalDistribution theNormalDistribution;

    PutPriceCalculator(@NotNull NormalDistribution aNormalDistribution) {
        theNormalDistribution = aNormalDistribution;
    }

    double calculate(double myForward, double myStrike, double aDOne, double aDTwo, double myDiscountFactor) {
        return myDiscountFactor * (myStrike * theNormalDistribution.cumulativeProbability(-aDTwo) -
                myForward * theNormalDistribution.cumulativeProbability(-aDOne));
    }

}
