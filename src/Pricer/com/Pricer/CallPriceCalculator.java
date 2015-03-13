package Pricer.com.Pricer;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.jetbrains.annotations.NotNull;

class CallPriceCalculator {

    @NotNull
    private final NormalDistribution theNormalDistribution;

    CallPriceCalculator(@NotNull NormalDistribution aNormalDistribution) {
        theNormalDistribution = aNormalDistribution;
    }

    double calculate(double aForward, double aStrike, double aDOne, double aDTwo) {
        return (aForward * theNormalDistribution.cumulativeProbability(aDOne) -
                aStrike * theNormalDistribution.cumulativeProbability(aDTwo));
    }

}
