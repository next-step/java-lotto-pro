package lotto.domain;

import lotto.view.OutputView;

import java.util.Objects;

public class TotalLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_ERROR = "잘못된 금액을 입력하셨습니다.";

    private int count;

    private Lottos lottoList;

    private Lotto winningLotto;

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

    public void count(int amount) {
        this.count = isCalculatorCount(amount);
    }

    public void countAndLottos(int amount) {
        this.count = isCalculatorCount(amount);

        Lottos lottos = new Lottos(this.count);
        this.lottoList = lottos;
    }

    public void winningLotto(String input) {
        this.winningLotto = new Lotto(input);
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

    public LottoStatistic calculatorLottoStatic() {
        LottoStatistic lottoStatistic = new LottoStatistic();
        for (Lotto lotto : this.lottoList.getLottoList()) {
            lottoStatistic.calculatorCount(MatchesLottoNumber(lotto));
        }
        lottoStatistic.calculatorProfitLate(this.count * LOTTO_PRICE);
        return lottoStatistic;
    }

    public int MatchesLottoNumber(Lotto lotto) {
        int count = 0;
        for (int i=0; i<lotto.getLottoNumber().size(); i++) {
            count = countMatchesWinner(count, lotto.getLottoNumber().get(i));
        }
        return count;
    }

    private int countMatchesWinner(int count, LottoNumber target) {
        if (this.winningLotto.getLottoNumber().contains(target)) {
            return ++count;
        }
        return count;
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
