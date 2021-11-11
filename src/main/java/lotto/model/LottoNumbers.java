package lotto.model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import lotto.model.enums.Rank;

public class LottoNumbers {
    static final int NUMBER_SIZE = 6;
    static final String NUMBER_SIZE_ERR_MSG = "로또 숫자는 서로 다른 " + NUMBER_SIZE + "개로 구성되어야 합니다.";

    private final SortedSet<Number> numbers;

    public LottoNumbers(int... numbers) {
        this(Arrays.stream(numbers)
            .mapToObj(Number::of)
            .collect(toSet()));
    }

    public LottoNumbers(Set<Number> numbers) {
        Objects.requireNonNull(numbers);
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

    public Rank computeRank(Number bonusNumber, LottoNumbers winningNumbers) {
        Objects.requireNonNull(bonusNumber);
        Objects.requireNonNull(winningNumbers);

        int countOfMatch = winningNumbers.countMatches(numbers);
        boolean matchBonus = numbers.contains(bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int countMatches(Set<Number> others) {
        return (int)others.stream()
            .filter(this.numbers::contains)
            .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
