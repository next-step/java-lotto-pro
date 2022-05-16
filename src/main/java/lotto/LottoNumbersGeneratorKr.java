package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGeneratorKr implements LottoNumbersGenerator {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public List<Integer> generate() {
        List<Integer> numbers = IntStream.range(MIN, MAX + 1)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, NUMBER_OF_LOTTO_NUMBERS);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
