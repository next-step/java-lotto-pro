package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.generator.NumberGenerateStrategy;

public class LottoNumbers {

    public static final String NUMBERS_DELIMITER = ",";
    private static final String NUMBERS_PREFIX = "[";
    private static final String NUMBERS_SUFFIX = "]";
    private static final int MAX_LOTTO_NUMBER_SIZE = 6;

    private static final String LOTTO_NUMBERS_SIZE_ERROR =
            String.format("[ERROR] 로또는 &s개의 숫자야 합니다.", MAX_LOTTO_NUMBER_SIZE);
    private static final String LOTTO_NUMBERS_DUPLICATION_ERROR = "[ERROR] 중복된 숫자는 불가 합니다.";

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers from(NumberGenerateStrategy strategy) {
        return strategy.generate();
    }

    public static LottoNumbers from(List<Integer> numbers) {
        return new LottoNumbers(convertToLottoNumber(numbers));
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_ERROR);
        }
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        Set<LottoNumber> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_ERROR);
        }
    }

    private static List<LottoNumber> convertToLottoNumber(List<Integer> integers) {
        return integers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public int hitCounts(LottoNumbers otherNumbers) {
        return (int) otherNumbers.getNumbers().
                stream().
                filter(numbers::contains).
                count();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream().
                map(LottoNumber::toString).
                collect(Collectors.joining(NUMBERS_DELIMITER + " ", NUMBERS_PREFIX, NUMBERS_SUFFIX));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
