package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorMessage;

public class RandomNumberUtils {

    public static List<Integer> generateRandomNumberToList(int low, int max, int count) {
        List<Integer> numberList = createNumberList(low, max);
        Collections.shuffle(numberList);
        return createRandomNumberList(count, numberList);
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


    private RandomNumberUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }
}
