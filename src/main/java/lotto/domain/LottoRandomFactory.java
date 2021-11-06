package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConfig.FIRST_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.LAST_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MAX_COUNT_OF_ONE_LINE;

public class LottoRandomFactory {

    private static final List<LottoNumber> lottoNumbers;

    static {
        List<LottoNumber> baseLottoNumbers = new ArrayList<>();

        for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
            baseLottoNumbers.add(new LottoNumber(i));
        }
        lottoNumbers = baseLottoNumbers;
    }

    private LottoRandomFactory() {
        throw new UnsupportedOperationException();
    }

    public static List<LottoNumber> generateLineOfLottoNumber() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_COUNT_OF_ONE_LINE; i++) {
            randomLottoNumbers.add(lottoNumbers.get(i));
        }

        return randomLottoNumbers;
    }
}
