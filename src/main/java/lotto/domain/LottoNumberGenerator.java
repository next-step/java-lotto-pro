package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_SIZE = 6;
    private static final String BLANK_FORMAT = " ";
    private static final String REPLACE_FORMAT = "";
    private static final String SPLIT_DELIMITER = ",";

    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(Collectors.toList());

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> from(String lottoNumbers) {
        return Arrays
                .stream(lottoNumbers.replace(BLANK_FORMAT, REPLACE_FORMAT).split(SPLIT_DELIMITER))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
