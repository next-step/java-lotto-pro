package play.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_INDEX = 0;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateLottoNumbers() {

        List<Integer> rangeNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed().collect(Collectors.toList());

        Collections.shuffle(rangeNumbers);

        List<Integer> lottoNumbers = rangeNumbers.subList(MIN_LOTTO_INDEX, LOTTO_SIZE);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
