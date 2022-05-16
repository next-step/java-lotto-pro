package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private LottoNumbersGenerator() {
    }

    public static List<Integer> generate(int min, int max, int count) {
        List<Integer> numbers = IntStream.range(min, max)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, count);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
