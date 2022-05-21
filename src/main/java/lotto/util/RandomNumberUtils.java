package lotto.util;

import lotto.LottoNumber;
import lotto.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberUtils {

    public static final int MAX_COUNT = 6;

    public static final int NUMBER_RANGE_FROM = 1;

    public static final int NUMBER_RANGE_TO = 45;

    private static List<Integer> numberPool;

    static {
        numberPool = new ArrayList<>();
        for (int i = NUMBER_RANGE_FROM; i <= NUMBER_RANGE_TO; i++) {
            numberPool.add(i);
        }
    }

    private RandomNumberUtils() { }

    public static LottoNumbers generateRandomNumber() {
        List<Integer> lottoNumberPool = new ArrayList<>(numberPool);
        Collections.shuffle(lottoNumberPool);

        ArrayList<LottoNumber> numbers = new ArrayList<>();
        for (int i = 1; i <= MAX_COUNT; i++) {
            numbers.add(new LottoNumber(lottoNumberPool.get(i)));
        }

        Collections.sort(numbers);
        LottoNumbers result = new LottoNumbers(numbers);
        return result;
    }
}
