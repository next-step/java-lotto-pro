package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerUtils {

    private IntegerUtils() {
    }

    public static List<Integer> createIntegersBetween(final int minNumber, final int maxNumber) {
        return IntStream.rangeClosed(minNumber, maxNumber)
                .boxed()
                .collect(Collectors.toList());
    }
}
