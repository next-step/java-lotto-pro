package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    public static List<Integer> PREPARED_NUMBERS;
    static {
        PREPARED_NUMBERS = new ArrayList<>();
        IntStream.rangeClosed(START_NUMBER, END_NUMBER)
                .boxed()
                .distinct()
                .forEach(PREPARED_NUMBERS::add);
    }
}
