package lotto.domain;

import lotto.consts.PriceConst;

public class Price {

    private final int price;

    public Price(int price) {
        validationCheck(price);
        this.price = price;
    }

    private void validationCheck(int price) {
        if (price < PriceConst.LOTTO_PRICE)
            throw new IllegalArgumentException();
    }

    public int getNumberOfLotto() {
        return price / PriceConst.LOTTO_PRICE;
    }

    public ProfitRate getProfitRate(WinningStats winningStats) {
        return new ProfitRate(Math.floor((double) 5000 / price * 100) / 100.0);
    }
}
