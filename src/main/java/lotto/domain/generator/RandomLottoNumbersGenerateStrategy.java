package lotto.domain.generator;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUM;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumbers;

public class RandomLottoNumbersGenerateStrategy implements LottoNumbersGenerateStrategy {

    private static final List<Integer> lottoNos = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNos.add(i);
        }
    }

    @Override
    public LottoNumbers generate() {
        Collections.shuffle(lottoNos);
        List<Integer> result = lottoNos.subList(0, 6);
        Collections.sort(result);
        return LottoNumbers.from(result);
    }
}
