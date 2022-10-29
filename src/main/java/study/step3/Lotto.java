package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int SUB_LIST_START_INDEX = 0;
    public static final int SUB_LIST_END_INDEX = 6;

    private final List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> makeLotto() {
        numbers.addAll(NumberSet.shuffledNumberSet()
                .subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX));
        Collections.sort(numbers);
        return numbers;
    }

    public int compare(List<Integer> winNumbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += compareNumber(winNumbers, number);
        }
        return result;
    }

    private static int compareNumber(List<Integer> winNumbers, Integer number) {
        return winNumbers.contains(number) ? 1 : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
