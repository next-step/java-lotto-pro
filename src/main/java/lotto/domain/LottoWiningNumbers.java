package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.common.Messages.LOTTO_NUMBERS_SIZE;
import static lotto.common.Messages.LOTTO_WINING_SEPARATOR;

public class LottoWiningNumbers {
    private static final int SIZE = 6;
    private static final String SEPARATOR = ",";

    private final String[] winingNumbers;

    public LottoWiningNumbers(String winningNumberString) {
        validateSeparator(winningNumberString);
        validateWiningNumbers(winningNumberString);

        this.winingNumbers = splitWiningNumber(winningNumberString);
    }

    public LottoNumbers generate() {
        return new LottoNumbers(Arrays.stream(winingNumbers)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    private void validateWiningNumbers(String text) {
        if (splitWiningNumber(text).length < SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateSeparator(String text) {
        if (!text.contains(SEPARATOR)) {
            throw new IllegalArgumentException(LOTTO_WINING_SEPARATOR);
        }
    }

    private String[] splitWiningNumber(String winningNumberString) {
        return winningNumberString.split(SEPARATOR);
    }
}
