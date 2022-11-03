package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    public static final List<LottoNumber> lottoNumbers = genLottoNumbers();

    private static List<LottoNumber> genLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return lottoNumbers;
    }

    public List<LottoNumber> getShuffledNum() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> subList = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(subList);
        return subList;
    }
}
