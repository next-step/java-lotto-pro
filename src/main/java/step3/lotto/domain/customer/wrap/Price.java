package step3.lotto.domain.customer.wrap;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:03 오후
 */
public class Price {

    public static final int MINIMUM_LOTTO_PRICE = 1_000;
    public static final String MINIMUM_LOTTO_PRICE_ERROR = "최소 1000원 이상의 금액을 입력하세요.";
    public static final String HAS_CHANGES_ERROR = "1000원 단위의 금액만 입력하세요.";

    private int price;

    private Price(int price) {
        this.price = price;
    }

    public static Price of(int price) {
        validatePrice(price);
        return new Price(price);
    }

    private static void validatePrice(int price) {
        validateMinimumLottoPrice(price);
        validateHasChanges(price);
    }

    private static void validateMinimumLottoPrice(int price) {
        if (price < MINIMUM_LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_LOTTO_PRICE_ERROR);
        }
    }

    private static void validateHasChanges(int price) {
        if (price % MINIMUM_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(HAS_CHANGES_ERROR);
        }
    }

    public int calculateAttemptsCount() {
        return this.price / MINIMUM_LOTTO_PRICE;
    }
}
