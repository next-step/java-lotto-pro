package lotto.utils;

import java.util.Random;

public class RandomNumberUtils {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Random RANDOM = new Random();

    public static int generateRandomNumbers(int min, int max) {
        validateNumberRange(min, max);
        return min + RANDOM.nextInt(max - min + 1);
    }

    private static void validateNumberRange(int min, int max) {
        if (max > MAX_NUMBER) {
            throw new IllegalArgumentException("최대값이 잘못되었습니다.");
        }
        if (min < MIN_NUMBER) {
            throw new IllegalArgumentException("최소값이 잘못되었습니다.");
        }
    }
}
