package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersRule {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> numbers = new ArrayList<>();

    public static List<Integer> shuffledNumbers() {
        if (numbers.isEmpty()) {
            addNumbers();
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    private static void addNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }
}
