package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = mapLottoNumber(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
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
}
