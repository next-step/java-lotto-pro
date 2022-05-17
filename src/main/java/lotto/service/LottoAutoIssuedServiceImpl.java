package lotto.service;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;

public class LottoAutoIssuedServiceImpl implements LottoIssuedService{
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;

    private static void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private static List<Integer> divideNumberList(List<Integer> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    @Override
    public List<Integer> issueLottoNumber() {
        List<Integer> lottoTargetNumbers = new LottoNumber().getNumbers();
        shuffleNumbers(lottoTargetNumbers);

        return divideNumberList(lottoTargetNumbers);
    }
}
