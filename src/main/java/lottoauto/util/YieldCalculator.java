package lottoauto.util;

public class YieldCalculator {

    public static double getYield(int price, int one, int two, int three, int four) {
        return price/(one+two+three+four);
    }
}
