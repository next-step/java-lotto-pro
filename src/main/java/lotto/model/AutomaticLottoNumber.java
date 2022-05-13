package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutomaticLottoNumber extends LottoNumber {

    private AutomaticLottoNumber(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static AutomaticLottoNumber generate() {
        List<Integer> automaticLottoNumber = generateAutomaticLottoNumber();
        return new AutomaticLottoNumber(automaticLottoNumber);
    }

    private static List<Integer> generateAutomaticLottoNumber() {
        shuffleNumberRange();
        return NUMBER_RANGE.stream()
                .limit(NUMBER_SIZE)
                .collect(Collectors.toList());
    }

    private static void shuffleNumberRange() {
        Collections.shuffle(NUMBER_RANGE);
    }
}
