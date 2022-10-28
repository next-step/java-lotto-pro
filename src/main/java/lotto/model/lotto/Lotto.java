package lotto.model.lotto;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int matches(LottoNumbers winningNumbers) {
        return this.lottoNumbers.matches(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
