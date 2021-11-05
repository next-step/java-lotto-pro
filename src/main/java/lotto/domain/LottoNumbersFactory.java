package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    public static final int LOTTO_NUMBERS_ZERO_SIZE = 0;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN_RANGE = 1;
    public static final int LOTTO_NUMBER_MAX_RANGE = 45;

    private LottoNumbersFactory() {
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> allLottoNumbers = createAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumbers = allLottoNumbers.subList(LOTTO_NUMBERS_ZERO_SIZE, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createAllLottoNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN_RANGE, LOTTO_NUMBER_MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());
    }
}
