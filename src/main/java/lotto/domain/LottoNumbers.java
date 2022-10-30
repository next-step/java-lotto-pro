package lotto.domain;

import static lotto.util.LottoUtil.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    public Prize calculatePrize(LottoNumbers winningLotto) {
        int winCount = 0;
        for (Integer number : this.numbers) {
            if (winningLotto.contains(number)) {
                winCount++;
            }
        }
        return Prize.of(winCount);
    }

    private void validate(Set<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException();
        }
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalStateException("로또번호는 6개의 숫자여야합니다.");
        }
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(Integer number) {
        if (number > END_NUMBER || number < BEGIN_NUMBER) {
            throw new IllegalStateException("유효한 숫자 범위가 아닙니다.");
        }
    }

    private boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        String printNumbers = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        return String.format("%s%s%s", "[", printNumbers, "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LottoNumbers that = (LottoNumbers)o;

        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
