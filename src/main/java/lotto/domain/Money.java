package lotto.domain;

import java.util.Objects;

public class Money {

    public static final int ZERO = 0;
    public static final int LOTTO_PRICE = 1000;
    public static final String PRICE_IS_MINUS_ERROR_MESSAGE = "금액은 0보다 작을 수 없습니다.";

    private int price;

    public Money(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < ZERO) {
            throw new IllegalArgumentException(PRICE_IS_MINUS_ERROR_MESSAGE);
        }
    }

    public LottoBundle buyAllRandomLotto() {
        int buyingLottoCount = price / LOTTO_PRICE;
        this.price = 0;

        return LottoBundleFactory.generateRandomLotto(buyingLottoCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return price == money.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
