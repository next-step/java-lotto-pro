package lotto.domain;

import lotto.utils.StringSplitter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.LottoNumberConstant.*;

public class LottoNumbersGenerator implements NumbersGenerator {
    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MINIMUM_VALUE, LOTTO_NUMBER_MAXIMUM_VALUE)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toList());

    public List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> generate(String lottoNumbers) {
        return Arrays
                .stream(StringSplitter.split(lottoNumbers))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
