package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Money {

    public static final int ZERO = 0;
    public static final int LOTTO_PRICE = 1000;
    public static final String PRICE_IS_MINUS_ERROR_MESSAGE = "금액은 0보다 작을 수 없습니다.";
    public static final String CUSTOM_LOTTO_COUNT_MISMATCH_ERROR_MESSAGE = "수동 로또 번호와 구입 갯수가 일치하지 않습니다.";
    public static final String TOO_MANY_REQUEST_BUY_CUSTOM_LOTTO_ERROR_MESSAGE = "요청한 수동 로또 구입 갯수가 너무 많습니다.";

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

    public boolean isAbleToBuyCustomLotto(int customLottoCount) {
        return customLottoCount <= price / LOTTO_PRICE;
    }

    public LottoBundle buyCustomLotto(List<List<LottoNumber>> customLottoNumbersBundle, int customLottoCount) {
        if (customLottoNumbersBundle.size() != customLottoCount) {
            throw new IllegalArgumentException(CUSTOM_LOTTO_COUNT_MISMATCH_ERROR_MESSAGE);
        }

        if (!isAbleToBuyCustomLotto(customLottoCount)) {
            throw new IllegalArgumentException(TOO_MANY_REQUEST_BUY_CUSTOM_LOTTO_ERROR_MESSAGE);
        }

        price -= customLottoCount * LOTTO_PRICE;

        return LottoBundleFactory.generateCustomLotto(customLottoNumbersBundle);
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
