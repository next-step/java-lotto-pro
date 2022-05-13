package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
