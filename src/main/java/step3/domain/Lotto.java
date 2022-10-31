package step3.domain;

import java.util.Objects;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public int compareNumbers(final LottoNumbers winningNumbers) {
        return this.lottoNumbers.compareTo(winningNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
