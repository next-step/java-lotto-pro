package util;

import static step3.domain.LottoNumber.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

public final class LottoNumbers {

    private static final int START_INDEX = 0;
    private static final List<LottoNumber> PREPARED_LOTTO_NUMBERS = new ArrayList<>(MAXIMUM_LOTTO_NUMBER);
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        for (int number = MINIMUM_LOTTO_NUMBER; number <= MAXIMUM_LOTTO_NUMBER; number++) {
            PREPARED_LOTTO_NUMBERS.add(new LottoNumber(number));
        }

        LOTTO_NUMBERS = new ArrayList<>(PREPARED_LOTTO_NUMBERS);
    }

    private LottoNumbers() {
    }

    public static List<LottoNumber> shuffle() {
        Collections.shuffle(LOTTO_NUMBERS);
        return get();
    }

    private static List<LottoNumber> get() {
        return LOTTO_NUMBERS.subList(START_INDEX, Lotto.LOTTO_LENGTH);
    }
}
