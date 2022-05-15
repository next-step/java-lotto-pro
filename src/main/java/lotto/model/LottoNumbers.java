package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoConstant.*;
import static lotto.utils.RandomUtils.createRandomNumbers;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<Integer> numbers) {
        lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
    }

    public static LottoNumbers createLottoNumbers() {
        List<Integer> randomNumbers = createRandomNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_PICK_COUNT);
        return new LottoNumbers(randomNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
