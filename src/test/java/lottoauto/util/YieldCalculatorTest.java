package lottoauto.util;

import org.junit.jupiter.api.Test;

public class YieldCalculatorTest {
    @Test
    void 수익율_계산() {
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int price = 1000;
        YieldCalculator yieldCalculator = new YieldCalculator();

        yieldCalculator.getYield(price, one, two, three, four);
    }
}
