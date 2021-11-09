package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoNumbers {
    static final int NUMBER_SIZE = 6;
    static final String NUMBER_SIZE_ERR_MSG = "로또 숫자는 서로 다른 " + NUMBER_SIZE + "개로 구성되어야 합니다.";

    private final SortedSet<Number> numbers;

    public LottoNumbers(int... numbers) {
        this(Arrays.stream(numbers).mapToObj(Number::ofValue).collect(toSet()));
    }

    public LottoNumbers(Set<Number> numbers) {
        this.numbers = Collections.unmodifiableSortedSet(new TreeSet<>(numbers));
        validate();
    }

    private void validate() {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERR_MSG);
        }
    }

    public boolean contains(Number obj) {
        return numbers.contains(obj);
    }

    public int getCountOfMatch(LottoNumbers winningNumbers) {
        return winningNumbers.getCountOfMatch(numbers);
    }

    private int getCountOfMatch(Set<Number> others) {
        return (int)others.stream().filter(this.numbers::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
