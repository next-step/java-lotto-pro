package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;

public class LottoMoney {
    private final static int LOTTO_PRICE = 1000;
    private final int money;

    public LottoMoney(final int money) {
        if (0 > money) {
            throw new IllegalArgumentException("input is not negative");
        }
        this.money = money;
    }

    public boolean isBuyable() {
        return money >= LOTTO_PRICE;
    }

    public LottoMoney buy() {
        return new LottoMoney(this.money - LOTTO_PRICE);
    }

    public EarningsRate calculate(final long totalMoney) {
        if (0 >= this.money) {
            throw new IllegalStateException("invalid money");
        }
        double rate = Double.longBitsToDouble(totalMoney) / Double.longBitsToDouble(this.money);
        return new EarningsRate(Math.floor(rate * 100) / 100.0);
    }

    public LottoMoney excludingAmount(final List<Lotto> lotto) {
        int i = this.money - (LOTTO_PRICE * lotto.size());
        return new LottoMoney(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMoney lottoMoney = (LottoMoney) o;
        return money == lottoMoney.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
