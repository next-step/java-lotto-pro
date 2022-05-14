package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;
import lotto.enums.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());
    }

    public Rank rank(LottoTicket winningNumbers) {
        return Rank.rank(matchCount(winningNumbers));
    }

    public int matchCount(LottoTicket winningNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
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
        if (lottoNumbers == null || lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_SIZE_LOTTO);
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
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
