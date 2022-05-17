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

    public Lottos getLottoList() {
        return this.lottoList;
    }

    public void of(int amount) {
        this.count = isCalculatorCount(amount);
        Lottos lottos = new Lottos();
        lottos.autoGenerator(this.count);
        this.lottoList = lottos;
    }

    private int isCalculatorCount(int amount) {
        return amount/LOTTO_PRICE;
    }

    public String lottoListToString() {
        StringBuilder sb = new StringBuilder();
        this.lottoList.getLottoList().stream()
                .forEach(lotto -> sb.append(lotto.toString() + "\n"));
        return sb.toString();
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
