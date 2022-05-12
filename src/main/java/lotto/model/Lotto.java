package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String ERROR_MESSAGE_MUST_BE_SIX_NUMBER = "로또는 서로 다른 6개의 숫자여야 합니다.";
    private static final int SIZE = 6;

    private final Set<Number> numbers = new HashSet<>();

    public Lotto() {
        this(LottoNumbers.pick());
    }

    public Lotto(List<Number> numbers) {
        this.numbers.addAll(numbers);
        if (this.numbers.size() != SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MUST_BE_SIX_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().map(Number::getNumber).sorted().collect(Collectors.toList());
    }

    public Result getResult(Lotto winner) {
        int count = 0;
        for (Number number : winner.numbers) {
            count = plusCountIfContains(count, number);
        }
        return Result.from(count);
    }

    private int plusCountIfContains(int count, Number number) {
        if (numbers.contains(number)) {
            count++;
        }
        return count;
    }
}
