package lotto.model;

public class LottoQuantityChecker {
    private static final String INVALID_PRICE = "1000원 단위의 금액을 입력하세요";
    private static final int LOTTO_PRICE = 1000;

    public static int check(String source) {
        int price = Integer.parseInt(source);
        validate(price);
        return price / LOTTO_PRICE;
    }

    private static void validate(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }
}
