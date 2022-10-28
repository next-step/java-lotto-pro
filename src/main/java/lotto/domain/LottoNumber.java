package lotto.domain;

import static lotto.util.LottoUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    //todo set
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public Prize calculateWinPrize(LottoNumber winningLotto) {
        int winCount = 0;
        for (Integer number : this.numbers) {
            if (winningLotto.contains(number)) {
                winCount++;
            }
        }
        return Prize.of(winCount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalStateException();
        }
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalStateException();
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalStateException();
        }
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(Integer number) {
        if (number > 45 || number < 0) {
            throw new IllegalStateException();
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

        LottoNumber that = (LottoNumber)o;

        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
