package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String numbers) {
        this.lottoNumbers = LottoNumbers.generate(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = LottoNumbers.generate(numbers);
    }

    public int match(Lotto target) {
        return lottoNumbers.match(target.lottoNumbers);
    }

    public void print() {
        lottoNumbers.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
