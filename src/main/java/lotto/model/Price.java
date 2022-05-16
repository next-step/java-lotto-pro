package lotto.model;

public class Price {
    private static final int LOTTO_PRICE = 1000;
    private static final String MINIMUM_PRICE_ERROR_MESSAGE = "최소 구입금액은 " + LOTTO_PRICE + "원 입니다.";

    public static void minimumPriceCheck(String money) {
        int price = Integer.parseInt(money);
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_PRICE_ERROR_MESSAGE);
        }
    }

    public static int lottoPrice() {
        return LOTTO_PRICE;
    }
}
