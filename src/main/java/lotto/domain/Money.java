package lotto.domain;

import lotto.constant.LottoMessage;

public class Money {
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
        if(price < 1000) {
            throw new IllegalArgumentException(LottoMessage.ERROR_MONEY_MIN_PRICE);
        }
    }

    public int lottoCount() {
        return price / 1000;
    }

    public int getPrice() {
        return price;
    }
}
