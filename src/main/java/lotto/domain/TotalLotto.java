package lotto.domain;

import java.util.Objects;

public class TotalLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_ERROR = "잘못된 금액을 입력하셨습니다.";

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

    public Lottos getLottoList() {
        return this.lottoList;
    }

    public void count(String input) throws IllegalArgumentException {
        int amount = amountStringToInt(input);
        this.count = calculatorCount(amount);
    }

    public void countAndLottos(String input) throws IllegalArgumentException {
        int amount = amountStringToInt(input);
        this.count = calculatorCount(amount);

        Lottos lottos = new Lottos(this.count);
        this.lottoList = lottos;
    }

    private int amountStringToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    private int calculatorCount(int amount) throws IllegalArgumentException {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(INPUT_ERROR);
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
