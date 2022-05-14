package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.LOTTO_NUMBER_SIZE;

public class LottoGenerator {

    private static final List<Integer> LOTTO_GENERATOR = new ArrayList<>();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            LOTTO_GENERATOR.add(number);
        }
    }

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_GENERATOR);

        return LOTTO_GENERATOR.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
