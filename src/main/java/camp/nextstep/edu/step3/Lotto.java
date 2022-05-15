package camp.nextstep.edu.step3;

import java.util.*;

public class Lotto {
    private static final int VALID_SIZE = 6;
    private final Set<LottoNumber> lottoNumbers = new TreeSet<>();

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this(new HashSet<>(lottoNumbers));
    }

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        validationSize(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public Hit checkTo(final Lotto prizeLotto) {
        return Hit.valueOf(prizeLotto.checkBy(this.lottoNumbers));
    }

    private void validationSize(Set<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty() || lottoNumbers.size() < VALID_SIZE) {
            throw new IllegalArgumentException("invalid LottoNumbers");
        }
    }

    private int checkBy(Set<LottoNumber> userLottoNumbers) {
        return userLottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .toArray().length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
