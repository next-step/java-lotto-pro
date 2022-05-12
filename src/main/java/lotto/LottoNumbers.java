package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = mapLottoNumber(numbers);
    }

    private List<LottoNumber> mapLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int collect(List<Integer> winNumbers) {
        return Math.toIntExact(winNumbers.stream()
                .filter(number -> numbers.contains(new LottoNumber(number)))
                .count());
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
}
