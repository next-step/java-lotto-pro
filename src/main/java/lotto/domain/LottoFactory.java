package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    public static final int LOTTO_SIZE = 6;

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int START_LOTTO_NUMBER_INDEX = 0;

    public static LottoNumbers createLottoNumbers() {
        if (isEmptyLottoNumbers()) {
            initLottoNumbers();
        }

        Collections.shuffle(lottoNumbers);
        List<LottoNumber> shuffledNumbers = new ArrayList<>(lottoNumbers.subList(START_LOTTO_NUMBER_INDEX, LOTTO_SIZE));
        Collections.sort(shuffledNumbers);

        return new LottoNumbers(shuffledNumbers);
    }

    private static boolean isEmptyLottoNumbers() {
        return lottoNumbers.isEmpty();
    }

    private static void initLottoNumbers() {
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }
}
