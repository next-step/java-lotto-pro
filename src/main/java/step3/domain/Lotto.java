package step3.domain;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int compareNumbers(final LottoNumbers winningNumbers) {
        return this.lottoNumbers.compareTo(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
