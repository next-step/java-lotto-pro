package lotto.domain;

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

    public void winningLotto(String input) {
        this.winningLotto = new Lotto(input);
    }

    private int amountStringToInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    private int calculatorCount(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }

        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return amount/LOTTO_PRICE;
    }

    public LottoStatic calculatorLottoStatic() {
        LottoStatic lottoStatic = new LottoStatic();
        for (Lotto lotto : this.lottoList.getLottoList()) {
            int count = MatchesLottoNumber(lotto);
            lottoStatic.calculator(count);
        }
        return lottoStatic;
    }

    public int MatchesLottoNumber(Lotto lotto) {
        int count = 0;
        for (int i=0; i<lotto.getLottoNumber().size(); i++) {
            count = countMatchesWinner(count, lotto.getLottoNumber().get(i));
        }
        return count;
    }

    private int countMatchesWinner(int count, int target) {
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
