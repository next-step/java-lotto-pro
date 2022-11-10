package lotto.domain.lotto;

import static lotto.utils.Validations.requireNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int SIZE = 6;

    private final Set<LottoNumber> numbers;

    public LottoNumbers(Set<LottoNumber> numbers) {
        requireNotNull(numbers, "숫자들은 null이 아니어야 합니다.");
        requireNumberNotNull(numbers);
        requireSix(numbers);

        this.numbers = numbers;
    }

    public LottoNumbers(List<Integer> numbers) {
        this(convertToLottoNumberSet(numbers));
    }

    public LottoNumbers(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    private static void requireNumberNotNull(Set<LottoNumber> numbers) {
        numbers.forEach(number -> requireNotNull(number, "숫자들에 null이 포함되지 않아야 합니다. value=" + numbers));
    }

    private static Set<LottoNumber> convertToLottoNumberSet(List<Integer> numbers) {
        requireNotNull(numbers, "null이 아니어야 합니다.");

        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static void requireSix(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자 6개여야 합니다. numbers=" + numbers);
        }
    }

    public List<Integer> toInts() {
        return this.numbers.stream()
                .map(LottoNumber::toInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public long countMatchedNumber(LottoNumbers other) {
        return this.numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
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
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
