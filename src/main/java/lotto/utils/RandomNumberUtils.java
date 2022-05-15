package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.ErrorMessage;

public class RandomNumberUtils {

    private static final String UNDER_SCORE = "_";
    private static final Map<String, List<Integer>> numbersCache = new HashMap<>();

    private RandomNumberUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static List<Integer> generateRandomNumbers(int low, int max, int count) {
        List<Integer> numbers = getNumbers(low, max);
        Collections.shuffle(numbers);
        return createRandomNumbers(count, numbers);
    }

    private static List<Integer> getNumbers(int low, int max) {
        String cacheKey = generateKey(low, max);
        if (numbersCache.containsKey(cacheKey)) {
            return numbersCache.get(cacheKey);
        }
        List<Integer> numbers = createNumbers(low, max);
        numbersCache.put(cacheKey, numbers);
        return numbers;
    }

    private static String generateKey(int low, int max) {
        return low + UNDER_SCORE + max;
    }

    private static List<Integer> createNumbers(int low, int max) {
        List<Integer> numbers = new ArrayList<>();
        for (int number = low; number <= max; number++) {
            numbers.add(number);
        }
        return numbers;
    }

    private static List<Integer> createRandomNumbers(int count, List<Integer> shuffleNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            randomNumbers.add(shuffleNumbers.get(index));
        }
        return randomNumbers;
    }

}
