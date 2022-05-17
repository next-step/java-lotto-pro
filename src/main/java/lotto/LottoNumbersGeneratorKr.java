package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberBounds;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGeneratorKr implements LottoNumbersGenerator {

    public List<Integer> generate() {
        List<Integer> numbers = IntStream.range(LottoNumberBounds.MIN.getValue(), LottoNumberBounds.MAX.getValue() + 1)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LottoGame.SIZE);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
