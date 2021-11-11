package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final static List<Number> lottoNumbers = createLottoNumbersCache();
    private final static int SUBLIST_FROM_INDEX = 0;
    private final static int SUBLIST_TO_INDEX = PickedNumbers.SIZE;

    private static List<Number> createLottoNumbersCache() {
        return IntStream.rangeClosed(Number.LOWER_BOUND, Number.UPPER_BOUND)
            .boxed()
            .map(Number::new)
            .collect(Collectors.toList());
    }

    public static PickedNumbers pickRandom() {
        Collections.shuffle(lottoNumbers);
        final List<Number> randoms = lottoNumbers.subList(SUBLIST_FROM_INDEX, SUBLIST_TO_INDEX);
        Collections.sort(randoms);
        return new PickedNumbers(randoms);
    }
}
