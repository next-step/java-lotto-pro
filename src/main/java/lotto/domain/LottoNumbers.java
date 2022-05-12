package lotto.domain;

import lotto.utils.StringSplitter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.LottoNumberConstant.*;

public class LottoNumbers {
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MINIMUM_VALUE, LOTTO_NUMBER_MAXIMUM_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> of(String lottoNumbers) {
        return Arrays
                .stream(StringSplitter.split(lottoNumbers))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
