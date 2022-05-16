package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGeneratorKr implements LottoNumbersGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = IntStream.range(ConstantsKr.MIN, ConstantsKr.MAX + 1)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, ConstantsKr.NUMBER_OF_LOTTO_NUMBERS);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
