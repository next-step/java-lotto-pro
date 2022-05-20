package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.ExceptionConstants.LOTTO_LENGTH_EXCEPTION;
import static lotto.constants.ExceptionConstants.LOTTO_OVERLAP_EXCEPTION;

public class Lotto {
    private static final int LIMIT_LOTTO = 6;
    private static final String DELIMITER = ",";
    private final List<LottoNumber> lotto;

    public Lotto(final String lottoNumbers) {
        this(
                Stream.of(lottoNumbers.split(DELIMITER))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lotto = lottoNumbers;
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);
        validateOverlap(lottoNumbers);
    }

    private void validateLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LIMIT_LOTTO) {
            throw new IllegalArgumentException(LOTTO_LENGTH_EXCEPTION);
        }
    }

    private void validateOverlap(List<LottoNumber> lottoNumbers) {
        long count = lottoNumbers.stream().distinct().count();

        if (count != LIMIT_LOTTO) {
            throw new IllegalArgumentException(LOTTO_OVERLAP_EXCEPTION);
        }
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lotto);
    }

    public long matchCount(final Lotto answer) {
        return answer.lotto.stream()
                .filter(this::contains)
                .count();
    }

    private boolean contains(final LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" + "lotto=" + lotto + '}';
    }
}
