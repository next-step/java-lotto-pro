package lotto.model;

import lotto.view.ErrorMessage;

import java.math.BigInteger;

public class Price {
    private static final int LOTTO_PRICE = 1000;

    private Price() {
    }

    public static int numberPurchases(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LACK_OF_MONEY);
        }
        return price / LOTTO_PRICE;
    }

    public static BigInteger totalPurchase(int count) {
        BigInteger price = new BigInteger(String.valueOf(LOTTO_PRICE));
        return price.multiply(new BigInteger(String.valueOf(count)));
    }
}
