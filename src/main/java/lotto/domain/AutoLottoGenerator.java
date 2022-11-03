package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> availableLottoRange = availableLottoRange();

    @Override
    public LottoNumbers generateLottoNumber() {
        return new LottoNumbers(getShuffleLottoNumber());
    }

    private static List<Integer> getShuffleLottoNumber() {
        List<Integer> lottoNumbers = availableLottoRange;
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(MIN_SIZE, MAX_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> availableLottoRange() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
