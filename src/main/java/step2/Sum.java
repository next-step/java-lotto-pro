package step2;

import java.util.Arrays;

public class Sum {

    private static final String NEGATIVE_NUMBER_MESSAGE = "음수는 포함될 수 없습니다";

    public static int from(int[] numbers){
        return Arrays.stream(numbers)
                .filter(Sum::filterPositive)
                .sum();
    }

    private static boolean filterPositive(int number){
        if(number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_MESSAGE);
        }
        return true;
    }
}
