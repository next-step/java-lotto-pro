package lotto.util;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGeneratorUtil {
    public static final int LOTTO_NUMBERS_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(toList());
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
