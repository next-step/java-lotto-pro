package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    public static final int LOTTO_MAX_SIZE = 6;

    public List<Integer> generate() {
        List<Integer> allNumbers = IntStream.range(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(allNumbers);
        return allNumbers.stream().limit(LOTTO_MAX_SIZE).collect(Collectors.toList());
    }
}
