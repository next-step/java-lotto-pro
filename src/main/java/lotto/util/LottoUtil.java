package lotto.util;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class LottoUtil {
    public static final int LOTTO_NUMBERS_COUNT = 6;

    private LottoUtil() {
    }

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static LottoNumber toLottoNumber(String numberString) {
        if (numberString == null) {
            throw new IllegalStateException();
        }
        List<Integer> numbers = Arrays.stream(numberString.split(","))
            .map(s -> Integer.parseInt(s.trim()))
            .collect(toList());
        return new LottoNumber(numbers);
    }

}
