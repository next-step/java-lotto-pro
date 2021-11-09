package util;

import static step3.domain.LottoNumber.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoNumber;

public final class LottoNumbers {

    private static final int START_INDEX = 0;
    private static final String DELIMITER = ",";

    private static final List<LottoNumber> PREPARED_LOTTO_NUMBERS = new ArrayList<>(MAXIMUM_LOTTO_NUMBER);

    static {
        for (int number = MINIMUM_LOTTO_NUMBER; number <= MAXIMUM_LOTTO_NUMBER; number++) {
            PREPARED_LOTTO_NUMBERS.add(new LottoNumber(number));
        }
    }

    private LottoNumbers() {
    }

    public static List<LottoNumber> shuffle() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>(PREPARED_LOTTO_NUMBERS);
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(START_INDEX, Lotto.LOTTO_LENGTH);
    }

    public static List<LottoNumber> split(final String numbers) {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (String number : numbers.split(DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Numbers.parseInt(number.replace(" ", ""))));
        }

        return lottoNumbers;
    }
}
