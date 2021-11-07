package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGeneratorUtils {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PICK_QUANTITY = 6;

    private RandomGeneratorUtils() {
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> numberRange = new ArrayList<Integer>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            numberRange.add(i);
        }
        List<Integer> numbers = new ArrayList<Integer>();
        Collections.shuffle(numberRange);
        for (int i = 0; i < LOTTO_PICK_QUANTITY; i++) {
            numbers.add(numberRange.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }
}
