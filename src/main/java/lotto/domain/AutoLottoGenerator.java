package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    private static final int MIN_LOTTO_NUM;
    private static final int MAX_LOTTO_NUM;
    public static final List<LottoNumber> lottoNumbers;

    static {
        MIN_LOTTO_NUM = 1;
        MAX_LOTTO_NUM= 45;
        lottoNumbers = genLottoNumbers();
    }

    private static List<LottoNumber> genLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return lottoNumbers;
    }

    public Lotto genAutoLotto() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> subList = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(subList);
        return new Lotto(subList);
    }
}
