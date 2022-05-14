package Lotto;

import Lotto.utils.StringSplitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Lotto {
    private static final ArrayList<Integer> rangeNumbers = IntStream.range(1, 45)
                                                                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto() {
        Collections.shuffle(rangeNumbers);
        this.numbers = generate();
        Collections.sort(numbers);
    }

    public Lotto(String customNumbers) {
        List<Integer> customNumbersToInt = StringSplitUtils.basicDetermiterSplit(customNumbers);
        this.numbers = customNumbersToInt;
    }

    private List<Integer> generate() {
        return rangeNumbers.subList(0, 6);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
            sb.append(number + ", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(", "));
        return "[" + sb + "]";
    }
}
