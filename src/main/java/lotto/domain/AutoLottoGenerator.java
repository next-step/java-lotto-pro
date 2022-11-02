package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public AutoLottoGenerator() {
        genLottoNumbers();
    }

    private void genLottoNumbers() {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getShuffledNum() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }
}
