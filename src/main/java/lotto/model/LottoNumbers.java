package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int NUMBER_SIZE = 6;
    static final String NUMBER_SIZE_ERR_MSG = "로또 숫자는 " + NUMBER_SIZE + "개로 구성되어야 합니다.";

    private final SortedSet<Number> numbers;

    public LottoNumbers(NumberSupplier numberSupplier) {
        this.numbers = Collections.unmodifiableSortedSet(new TreeSet<>(numberSupplier.getNumbers()));
        validate();
    }

    public LottoNumbers(int... numbers) {
        this(() -> Arrays.stream(numbers).mapToObj(Number::new).collect(Collectors.toSet()));
    }

    private void validate() {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERR_MSG);
        }
    }

    public MatchCount getMatchCount(LottoNumbers other) {
        return other.getMatchCount(this.numbers);
    }

    private MatchCount getMatchCount(Set<Number> numbers) {
        int matchCount = 0;
        for (Number number : numbers) {
            matchCount += getMatchCount(number);
        }
        return MatchCount.ofValue(matchCount);
    }

    private int getMatchCount(Number other) {
        if (this.numbers.contains(other)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
