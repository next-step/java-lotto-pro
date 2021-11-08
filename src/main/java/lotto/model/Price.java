package lotto.model;

import java.math.BigInteger;

public class Price {
    private static final int LOTTO_PRICE = 1000;

    public static int numberPurchases(int price) {
        return price / LOTTO_PRICE;
    }

    public static BigInteger totalPurchase(int count) {
        BigInteger price = new BigInteger(String.valueOf(LOTTO_PRICE));
        return price.multiply(new BigInteger(String.valueOf(count)));
    }
}
