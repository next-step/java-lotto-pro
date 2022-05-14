package lotto.model;

public class LottoQuantityChecker {
    private static final int LOTTO_PRICE = 1000;

    public static int calculate(String source) {
        int price = Integer.parseInt(source);
        return price / LOTTO_PRICE;
    }
}
