package lotto.domain;

import lotto.constant.LottoMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int price;
    public Money(int price) {
        this.price = validateMoney(price);
    }

    private int validateMoney(int price) {
        validatePositiveMoney(price);
        validateMinLottoMoney(price);
        return price;
    }

    private void validatePositiveMoney(int price) {
        if(price < 0) {
            throw new IllegalArgumentException(LottoMessage.ERROR_MONEY_NEGATIVE);
        }
    }

    private void validateMinLottoMoney(int price) {
        if(price < LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoMessage.ERROR_MONEY_MIN_PRICE);
        }
    }

    public int lottoCount() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public int totalLottoPrice() {
        return lottoCount() * LOTTO_PRICE;
    }
}
