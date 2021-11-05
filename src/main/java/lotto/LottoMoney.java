package lotto;

import java.util.Objects;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private long money;

    public LottoMoney(String moneyText) {
        money = Integer.parseInt(moneyText);
    }

    public LottoMoney(long money) {
        this.money = money;
    }

    public LottoCount calculateLottoCount() {
        return new LottoCount(money / LOTTO_PRICE);
    }

    public LottoMoney calculateMultiple(int multiple) {
        return new LottoMoney(money * multiple);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoMoney)) {
            return false;
        }
        LottoMoney that = (LottoMoney)o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
