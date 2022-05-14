package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumbersGenerator {
    private static List<Integer> baseLottoNumbers = new ArrayList<>();

    public static List<Integer> generate() {
        if (baseLottoNumbers.isEmpty()) {
            initializeBaseLottoNumbers();
        }
        Collections.shuffle(baseLottoNumbers);
        return baseLottoNumbers.subList(0, 6);
    }

    private static void initializeBaseLottoNumbers() {
        baseLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_NUMBER_MIN_VALUE; i <= LottoNumber.LOTTO_NUMBER_MAX_VALUE; i++) {
            baseLottoNumbers.add(i);
        }
    }

    public static List<Integer> getBaseLottoNumbers() {
        return baseLottoNumbers;
    }
}
