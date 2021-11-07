package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberUtils {
    public static List<Integer> generateRandomNumbers(int resultSize, int minInclusive, int maxInclusive) {
        final List<Integer> allNumbers = generateSequentialNumbers(minInclusive, maxInclusive);
        Collections.shuffle(allNumbers);
        final List<Integer> pickedNumbers = new ArrayList<>(allNumbers.subList(0, resultSize));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    private static List<Integer> generateSequentialNumbers(int minInclusive, int maxInclusive) {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = minInclusive; i <= maxInclusive; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
