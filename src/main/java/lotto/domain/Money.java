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

    public int lottoTotalCount() {
        return price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public int totalLottoPrice() {
        return lottoTotalCount() * LOTTO_PRICE;
    }

    public void checkManualLottoCount(int manualLottoCount) {
        validatePositiveCount(manualLottoCount);
        validateMaxLottoCount(manualLottoCount);
    }

    private void validatePositiveCount(int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException(LottoMessage.ERROR_NUM_NEGATIVE);
        }
    }

    private void validateMaxLottoCount(int manualLottoCount) {
        if (manualLottoCount > lottoTotalCount()) {
            throw new IllegalArgumentException(LottoMessage.ERROR_MESSAGE_MANUAL_LOTTO_COUNT);
        }
    }
}
