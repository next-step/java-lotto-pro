package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());
    }

    private void validate(List<Integer> lottoNumbers) {
        validateEmpty(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateEmpty(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY_LOTTO);
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_SIZE_LOTTO);
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
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
