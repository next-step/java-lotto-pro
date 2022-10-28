package lotto.domain;

import static lotto.util.LottoGeneratorUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        //todo 여기서 정렬해야할까?
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
    }

    public int calculateWinCount(LottoNumber myLotto) {
        int winCount = 0;
        for (Integer number : this.numbers) {
            if (myLotto.contains(number)) {
                winCount++;
            }
        }
        return winCount;
    }

    private boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        String printNumbers = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        return String.format("%s%s%s", "[", printNumbers, "]");
    }
}
