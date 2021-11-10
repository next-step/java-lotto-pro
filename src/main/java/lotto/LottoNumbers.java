package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final static List<Number> lottoNumbers = createLottoNumbersCache();

    private static List<Number> createLottoNumbersCache() {
        return IntStream.rangeClosed(Number.LOWER_BOUND, Number.UPPER_BOUND)
            .boxed()
            .map(Number::new)
            .collect(Collectors.toList());
    }
}
