package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(LottoNumbers.generate(numbers));
    }

    public static Lotto of(String numbers) {
        return new Lotto(LottoNumbers.generate(numbers));
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers.getLottoNumbers();
    }

    public int match(Lotto target) {
        return lottoNumbers.match(target.lottoNumbers);
    }

    public boolean match(LottoNumber lottoNumber) {
        return lottoNumbers.match(lottoNumber);
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
