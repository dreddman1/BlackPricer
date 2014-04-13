package Pricer.com.datamodel;

import org.jetbrains.annotations.NotNull;

public class PricerInputs {

    private final double theStrike;
    @NotNull
    private final OptionKind theOptionKind;
    private final double theForward;
    private final double theVolatility;
    private final double theVolaTimeToExpiry;

    public PricerInputs(double aStrike, @NotNull OptionKind aOptionKind, double aForward, double aVolatility,
                        double aVolaTimeToExpiry) {
        theStrike = aStrike;
        theOptionKind = aOptionKind;
        theForward = aForward;
        theVolatility = aVolatility;
        theVolaTimeToExpiry = aVolaTimeToExpiry;
    }

    double getTheStrike() {
        return theStrike;
    }

    @NotNull
    OptionKind getTheOptionKind() {
        return theOptionKind;
    }

    double getTheForward() {
        return theForward;
    }

    double getTheVolatility() {
        return theVolatility;
    }

    double getTheVolaTimeToExpiry() {
        return theVolaTimeToExpiry;
    }
}
