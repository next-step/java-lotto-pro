package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = Collections.unmodifiableList(mapToLottoNumbers(numbers));
    }

    public WinResult getWinResult(Lotto winNumber, LottoNumber bonusNumber) {
        int matchedCount = getMatchedCount(winNumber);
        boolean bonusNumberMatched = this.lottoNumbers.contains(bonusNumber);
        return WinResult.fromCount(matchedCount, bonusNumberMatched);
    }

    private void validate(List<Integer> numbers) {
        if (isIncorrectSize(numbers)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR.getMessage(), LOTTO_NUMBERS_SIZE));
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isIncorrectSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != LOTTO_NUMBERS_SIZE;
    }

    private List<LottoNumber> mapToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private int getMatchedCount(Lotto winNumber) {
        return (int) winNumber.lottoNumbers
                .stream()
                .map(this.lottoNumbers::contains)
                .filter(isContained -> isContained)
                .count();
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
        return lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
