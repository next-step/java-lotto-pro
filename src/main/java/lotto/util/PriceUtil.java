package lotto.util;

public class PriceUtil {
    private static final int lottoPrice = 1000;

    public static int getCount(int price) {
        return price/lottoPrice;
    }
}
