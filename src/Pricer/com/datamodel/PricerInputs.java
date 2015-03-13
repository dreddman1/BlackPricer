package Pricer.com.datamodel;

import org.jetbrains.annotations.NotNull;

public class PricerInputs {

    private final double theStrike;
    @NotNull
    private final OptionKind theOptionKind;
    private final double theForward;
    private final double theVolatility;
    private final double theVolaTimeToExpiry;
    private final double theInterestRate;

    public PricerInputs(double aStrike, @NotNull OptionKind aOptionKind, double aForward, double aVolatility,
                        double aVolaTimeToExpiry, double aInterestRate) {
        theStrike = aStrike;
        theOptionKind = aOptionKind;
        theForward = aForward;
        theVolatility = aVolatility;
        theVolaTimeToExpiry = aVolaTimeToExpiry;
        theInterestRate = aInterestRate;
    }

    public double getStrike() {
        return theStrike;
    }

    @NotNull
    public OptionKind getOptionKind() {
        return theOptionKind;
    }

    public double getForward() {
        return theForward;
    }

    public double getVolatility() {
        return theVolatility;
    }

    public double getVolaTimeToExpiry() {
        return theVolaTimeToExpiry;
    }

    public double getTheInterestRate() {
        return theInterestRate;
    }
}
