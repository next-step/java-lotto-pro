package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {
    }

    public static List<Integer> generate() {
        return pickNumbers(shuffleAllNumbers());
    }

    private static List<Integer> pickNumbers(List<Integer> numbers) {
        return numbers.subList(0, 6);
    }

    private static List<Integer> shuffleAllNumbers() {
        List<Integer> allNumbers = allNumbers();
        Collections.shuffle(allNumbers);

        return allNumbers;
    }

    private static List<Integer> allNumbers() {
        return LOTTO_NUMBERS;
    }
}
