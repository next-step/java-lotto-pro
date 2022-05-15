package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_STANDARD_SIZE = 6;
    private static final String INVALID_SIZE = "6개의 숫자가 입력되야합니다";
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = mapLottoNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_STANDARD_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int collect(List<Integer> winNumbers) {
        return Math.toIntExact(winNumbers.stream()
                .filter(number -> numbers.contains(new LottoNumber(number)))
                .count());
    }

    private List<LottoNumber> mapLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "numbers=" + numbers +
                '}';
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(new LottoNumber(bonusNumber));
    }
}
