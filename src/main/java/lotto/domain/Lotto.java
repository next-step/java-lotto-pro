package lotto.domain;

public class Lotto {

    private final Numbers numbers;

    public Lotto(LottoNumberPickStrategy lottoNumberPickStrategy) {
        this.numbers = new Numbers(lottoNumberPickStrategy.pick());
    }

    public int getMatchCount(Lotto lotto) {
        return numbers.getMatchCount(lotto.numbers);
    }
}
