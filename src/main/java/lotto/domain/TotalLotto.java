package lotto.domain;

import lotto.view.OutputView;

import java.util.Objects;

public class TotalLotto {
    private static final int LOTTO_PRICE = 1000;

    private int count;

    private Lottos lottoList;

    public TotalLotto() {
    }

    public TotalLotto(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void count(int amount) {
        this.count = isCalculatorCount(amount);
    }

    private int isCalculatorCount(int amount) {
        if (amount < 0) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }

        if (amount % LOTTO_PRICE > 0) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }

        return amount/LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalLotto totalLotto = (TotalLotto) o;
        return count == totalLotto.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
