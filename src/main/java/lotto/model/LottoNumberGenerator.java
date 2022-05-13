package lotto.model;

import static lotto.constants.LottoConstant.NUMBER_SIZE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.LottoConstant;

public class LottoNumberGenerator {
    private static final List<Number> lottoNumberRange;

    static {
        lottoNumberRange = IntStream.range(LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER + 1)
                .boxed()
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<Number> generate() {
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.stream()
                .limit(NUMBER_SIZE)
                .collect(Collectors.toList());
    }
}
