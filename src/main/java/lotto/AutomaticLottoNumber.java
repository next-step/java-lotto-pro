package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutomaticLottoNumber extends LottoNumber {

    public AutomaticLottoNumber() {
        super(createAutomaticNumber());
    }

    private static List<Integer> createAutomaticNumber() {
        shuffleNumberRange();
        return NUMBER_RANGE.stream()
                .limit(NUMBER_SIZE)
                .collect(Collectors.toList());
    }

    private static void shuffleNumberRange() {
        Collections.shuffle(NUMBER_RANGE);
    }
}
