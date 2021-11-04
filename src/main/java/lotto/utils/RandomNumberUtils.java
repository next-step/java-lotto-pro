package lotto.utils;

import java.util.Random;

public class RandomNumberUtils {


    private static final Random RANDOM = new Random();

    public static int generateRandomNumbers(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }


}
