package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.Objects;
import java.util.Set;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String INVALID_LOTTO_NUMBERS_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberException(INVALID_LOTTO_NUMBERS_COUNT_MESSAGE);
        }
    }

    public static LottoNumbers of(Set<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
