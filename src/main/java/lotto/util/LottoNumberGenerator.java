package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final int SUBLIST_START_IDX = 0;
    private static final int SUBLIST_END_IDX = 6;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoRange = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoRange.add(i);
        }
        Collections.shuffle(lottoRange);
        List<Integer> lottoNumbers = lottoRange.subList(SUBLIST_START_IDX, SUBLIST_END_IDX);
        lottoNumbers.sort(Comparator.comparingInt(i -> i));
        return lottoNumbers;
    }
}