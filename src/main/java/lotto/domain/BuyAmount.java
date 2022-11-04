package lotto.domain;

import java.util.Objects;

public class BuyAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MAX_BUY_AMOUNT = 2000000000;

    private int buyAmount;

    public BuyAmount(int buyAmount) {
        if(buyAmount < LOTTO_PRICE)
            throw new IllegalArgumentException("구입금액은 " + LOTTO_PRICE + "원 이상이여야 합니다.");
        if(buyAmount > LOTTO_MAX_BUY_AMOUNT)
            throw new IllegalArgumentException("구입금액은 " + LOTTO_MAX_BUY_AMOUNT + "원 이하여야 합니다.");
        this.buyAmount = buyAmount;
    }

    public Lotteries getLotteries(LottoCreator lottoCreator) {
        return lottoCreator.createLotteries(buyAmount/LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BuyAmount buyAmount1 = (BuyAmount) o;
        return buyAmount == buyAmount1.buyAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyAmount);
    }

    public boolean isEqualValue(int buyAmount) {
        return this.buyAmount == buyAmount;
    }

    public double getProfit(int winningPrice) {
        return (double)winningPrice/(double)buyAmount;
    }
}
