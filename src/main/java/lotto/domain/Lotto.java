package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;
    private final LottoType lottoType;

    private Lotto(List<Integer> numbers, LottoType lottoType) {
        validate(numbers);
        this.lottoNumbers = Collections.unmodifiableList(mapToLottoNumbers(numbers));
        this.lottoType = lottoType;
    }

    public static Lotto of(List<Integer> numbers, LottoType lottoType) {
        return new Lotto(numbers, lottoType);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers, LottoType.MANUAL);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchedCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .map(lotto::isContained)
                .filter(isContained -> isContained)
                .count();
    }

    public boolean isContained(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public boolean isManual() {
        return lottoType == LottoType.MANUAL;
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
}
