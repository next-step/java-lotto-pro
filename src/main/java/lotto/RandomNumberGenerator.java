package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    public static final int MAX_COUNT = 6;

    public static final int NUMBER_RANGE_FROM = 1;

    public static final int NUMBER_RANGE_TO = 45;

    private static List<Integer> numberPool;

    static {
        numberPool = new ArrayList<>();
        for (int i = NUMBER_RANGE_FROM; i <= NUMBER_RANGE_TO; i++) {
            numberPool.add(i);
        }
    }

    private RandomNumberGenerator() { }

    public static List<Integer> generateRandomNumber() {
        List<Integer> lottoNumberPool = new ArrayList<>(numberPool);
        Collections.shuffle(lottoNumberPool);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= MAX_COUNT; i++) {
            result.add(lottoNumberPool.get(i));
        }

        Collections.sort(result);
        return result;
    }
}
