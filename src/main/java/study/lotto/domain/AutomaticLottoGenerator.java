package study.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import study.lotto.domain.lottomachine.LottoGenerator;

public class AutomaticLottoGenerator implements LottoGenerator {
    @Override
    public List<LottoNumber> generate() {
        return generateRandomLottoNumbers();
    }

    private List<LottoNumber> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = shuffledLottoNumbers().subList(0, Lotto.LOTTO_NUMBER_SIZE);
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<Integer> shuffledLottoNumbers() {
        List<Integer> lottoNumbers = possibleLottoNumber();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> possibleLottoNumber() {
        return IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
