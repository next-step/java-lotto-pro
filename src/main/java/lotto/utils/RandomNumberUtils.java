package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.ErrorMessage;

public class RandomNumberUtils {

    private static final String UNDER_SCORE = "_";
    private static final Map<String, List<Integer>> numberListMap = new HashMap<>();

    private RandomNumberUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static List<Integer> generateRandomNumberToList(int low, int max, int count) {
        List<Integer> numberList;
        numberList = getNumberList(low, max);
        Collections.shuffle(numberList);
        return createRandomNumberList(count, numberList);
    }

    private static List<Integer> getNumberList(int low, int max) {
        String cacheKey = generateKey(low, max);
        if (numberListMap.containsKey(cacheKey)) {
            return numberListMap.get(cacheKey);
        }
        List<Integer>  numberList= createNumberList(low, max);
        numberListMap.put(cacheKey, numberList);
        return numberList;
    }

    private static String generateKey(int low, int max) {
        return low + UNDER_SCORE + max;
    }

    private static List<Integer> createNumberList(int low, int max) {
        List<Integer> numberList = new ArrayList<>();
        for (int number = low; number <= max; number++) {
            numberList.add(number);
        }
        return numberList;
    }

    private static List<Integer> createRandomNumberList(int count, List<Integer> shuffleNumberList) {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            randomNumberList.add(shuffleNumberList.get(index));
        }
        return randomNumberList;
    }

}
