package Pricer.com.Pricer;

import Pricer.com.datamodel.OptionKind;
import Pricer.com.datamodel.PricerInputs;
import Pricer.com.datamodel.PricerOutput;

public class PricerRunner {

    private static final double STRIKE = 100D;
    private static final OptionKind OPTION_KIND = OptionKind.CALL;
    private static final double FORWARD = 110D;
    private static final double VOLATILITY = 0.16;
    private static final double VOLA_TIME_TO_EXPIRY = 0.5;

    public static void main(String[] args) {

        PricerCore myPricer = new PricerCore(new DOneCalculator(), new DTwoCalculator());

        PricerInputs myPricerInputs = new PricerInputs(STRIKE, OPTION_KIND, FORWARD, VOLATILITY, VOLA_TIME_TO_EXPIRY);

        PricerOutput myPricerOutput = myPricer.calculate(myPricerInputs);

    }
}
