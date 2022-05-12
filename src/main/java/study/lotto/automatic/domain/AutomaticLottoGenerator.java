package study.lotto.automatic.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutomaticLottoGenerator implements LottoGenerator {
    @Override
    public LottoNumbers generate() {
        return new LottoNumbers(generateRandomLottoNumbers());
    }

    private List<Integer> generateRandomLottoNumbers() {
        return shuffledLottoNumbers().subList(0, LottoNumbers.LOTTO_NUMBER_SIZE);
    }

    private List<Integer> shuffledLottoNumbers() {
        List<Integer> lottoNumbers = possibleLottoNumber();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> possibleLottoNumber() {
        return IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1).boxed()
                .collect(Collectors.toList());
    }
}
