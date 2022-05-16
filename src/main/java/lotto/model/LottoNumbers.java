package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static LottoNumbers createLottoNumbers(List<Integer> numbers) {
        checkNumberDuplicate(numbers);
        return new LottoNumbers(numbers);
    }

    private static void checkNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        boolean hasDuplicate = numberSet.size() <  LOTTO_PICK_COUNT;
        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복 값이 존재합니다!");
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
