package Pricer.com.Pricer;

import Pricer.com.datamodel.BlackPricerOutput;
import Pricer.com.datamodel.OptionKind;
import Pricer.com.datamodel.BlackPricerInputs;

public class BlackPricer {

    private static final double STRIKE = 100D;
    private static final OptionKind OPTION_KIND = OptionKind.CALL;
    private static final double FORWARD = 110D;
    private static final double VOLATILITY = 100;
    private static final double VOLA_TIME_TO_EXPIRY = 0.5;
    private static final double INTEREST_RATE = 10;

    public static void main(String[] args) {
        BlackPriceCalculator myBlackPriceCalculator = new BlackPriceCalculatorFactory().create();
        BlackPricerInputs myBlackPricerInputs = new BlackPricerInputs(STRIKE, OPTION_KIND, FORWARD, VOLATILITY,
                VOLA_TIME_TO_EXPIRY, INTEREST_RATE);
        BlackPricerOutput myBlackPricerOutput = myBlackPriceCalculator.calculate(myBlackPricerInputs);
        System.out.println(myBlackPricerOutput.getPrice());
    }
}
