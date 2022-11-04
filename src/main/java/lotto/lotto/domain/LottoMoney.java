package lotto.lotto.domain;

public class LottoMoney {

    public static final int LOTTO_MINIMUM_PRICE = 1000;
    private final int number;

    public LottoMoney(int number) {
        this.number = number;
        validateMultiple(number);
    }

    private static void validateMultiple(int number) {
        if (number % LOTTO_MINIMUM_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_MINIMUM_PRICE + "의 배수만 입력가능합니다.");
        }
    }

    public int purchaseCount() {
        return number / LOTTO_MINIMUM_PRICE;
    }

    public long getNumber() {
        return number;
    }
}
