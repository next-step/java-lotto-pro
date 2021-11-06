package lotto.util;

import java.math.BigInteger;

public class PriceUtil {
    private static final int lottoPrice = 1000;

    public static int getCount(int price) {
        return price / lottoPrice;
    }

    public static BigInteger getPurchase(int count) {
        BigInteger price = new BigInteger(String.valueOf(lottoPrice));
        return price.multiply(new BigInteger(String.valueOf(count)));
    }
}
