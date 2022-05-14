package lotto.domain;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConstants.NUMBERS_DELIMITER;
import static lotto.constants.LottoConstants.NUMBERS_PREFIX;
import static lotto.constants.LottoConstants.NUMBERS_SUFFIX;
import static lotto.messages.ErrorMessages.LOTTO_NUMBERS_DUPLICATION_ERROR;
import static lotto.messages.ErrorMessages.LOTTO_NUMBERS_SIZE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.generator.NumberGenerateStrategy;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers from(NumberGenerateStrategy strategy) {
        List<Integer> generatedNumbers = strategy.generate();
        return new LottoNumbers(convertToLottoNumber(generatedNumbers));
    }

    public static LottoNumbers from(List<LottoNumber> numbers) {
        return new LottoNumbers(numbers);
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
        return numbers;
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
