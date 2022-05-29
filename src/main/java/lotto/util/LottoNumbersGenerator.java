package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {
    private static final int DEFAULT_VALUE = 0;
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private static final int LOTTO_LINE_LENGTH = 6;
    private static final List<Integer> LOTTO_NUMBERS_CANDIDATE;

    private LottoNumbersGenerator(){}

    static {
        LOTTO_NUMBERS_CANDIDATE = IntStream.rangeClosed(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbersCandidate = new ArrayList<>(LOTTO_NUMBERS_CANDIDATE);
        Collections.shuffle(lottoNumbersCandidate);
        List<Integer> lottoNumbers = lottoNumbersCandidate.subList(DEFAULT_VALUE, LOTTO_LINE_LENGTH);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

}
