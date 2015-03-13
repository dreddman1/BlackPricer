package Pricer.com.Pricer;

import Pricer.com.datamodel.PricerOutputFactory;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.jetbrains.annotations.NotNull;

class BlackPriceCalculatorFactory {
    @NotNull
    BlackPriceCalculator create() {
        NormalDistribution myNormalDistribution = new NormalDistribution();
        return new BlackPriceCalculator(new DOneCalculator(), new DTwoCalculator(),
                new BlackPricerCore(new DiscountFactorCalculator(), new CallPriceCalculator(myNormalDistribution),
                        new PutPriceCalculator(myNormalDistribution)), new PricerOutputFactory());
    }
}
