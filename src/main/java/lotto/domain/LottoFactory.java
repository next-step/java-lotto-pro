package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private static List<LottoNumber> lottoNumberList = new ArrayList<>();

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int START_LOTTO_NUMBER_INDEX = 0;
    private static final int LOTTO_SIZE = 6;

    public static LottoNumbers createLottoNumbers() {
        if (isEmptyLottoNumberList()) {
            initLottoNumberList();
        }

        Collections.shuffle(lottoNumberList);
        List<LottoNumber> shuffledNumberList = lottoNumberList.subList(START_LOTTO_NUMBER_INDEX, LOTTO_SIZE);
        Collections.sort(shuffledNumberList);

        return new LottoNumbers(shuffledNumberList);
    }

    private static boolean isEmptyLottoNumberList() {
        return lottoNumberList.isEmpty();
    }

    private static void initLottoNumberList() {
        lottoNumberList = new ArrayList<>();
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
    }
}
