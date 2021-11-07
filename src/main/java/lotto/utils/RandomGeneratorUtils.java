package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.LottoNumbers;

public class RandomGeneratorUtils {

    private RandomGeneratorUtils() {
    }

    public static List<Integer> makeRandomNumbers() {
        List<Integer> numberRange = new ArrayList<Integer>();
        for (int i = LottoNumbers.LOTTO_MIN_NUMBER; i <= LottoNumbers.LOTTO_MAX_NUMBER; i++) {
            numberRange.add(i);
        }
        List<Integer> numbers = new ArrayList<Integer>();
        Collections.shuffle(numberRange);
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBER_QUANTITY; i++) {
            numbers.add(numberRange.get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }
}
