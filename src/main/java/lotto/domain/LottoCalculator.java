package lotto.domain;

import java.util.Objects;

public class LottoCalculator {

    private final Money LOTTO_PRICE = new Money(1000);
    private final Money money;

    public LottoCalculator(Money money) {
        validateMoney(money);
        this.money = money;
    }

    public void validateMoney(Money money) {
        if (!money.greaterEqualThan(LOTTO_PRICE)) {
            throw new IllegalArgumentException("로또를 구매하기에는 돈이 부족합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoCalculator)) return false;
        LottoCalculator that = (LottoCalculator) o;
        return Objects.equals(LOTTO_PRICE, that.LOTTO_PRICE) && Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_PRICE, money);
    }
}
