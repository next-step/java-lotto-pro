package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomFactory implements LottoFactory {

    public static final int FIRST_LOTTO_NUMBER = 1;
    public static final int LAST_LOTTO_NUMBER = 45;
    public static final int MAX_COUNT_OF_ONE_LINE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoRandomFactory() {
        List<LottoNumber> baseLottoNumbers = new ArrayList<>();

        for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
            baseLottoNumbers.add(new LottoNumber(i));
        }
        lottoNumbers = baseLottoNumbers;
    }

    public List<LottoNumber> generateLineOfLottoNumber() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < MAX_COUNT_OF_ONE_LINE; i++) {
            randomLottoNumbers.add(lottoNumbers.get(i));
        }

        return randomLottoNumbers;
    }
}
