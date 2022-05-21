package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_COUNT = 6;

    public static List<Integer> createRandomLottoNumber() {
        List<Integer> list = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        List<Integer> lottoNumbers = list.subList(0, LOTTO_COUNT);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
