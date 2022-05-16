package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoIssuedServiceImpl implements LottoIssuedService{
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;

    private static void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private static List<Integer> divideNumberList(List<Integer> lottoNumbers) {
        return lottoNumbers.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    @Override
    public List<Integer> issueLottoNumber() {
        List<Integer> lottoTargetNumbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN_VALUE; i <= LOTTO_NUMBER_MAX_VALUE; i++)
            lottoTargetNumbers.add(i);

        shuffleNumbers(lottoTargetNumbers);

        return divideNumberList(lottoTargetNumbers);
    }
}
