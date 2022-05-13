package lotto.generator;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUM;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumberGenerateStrategy implements NumberGenerateStrategy{

    private static final List<Integer> lottoNos = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUM; i <= MAX_LOTTO_NUM; i++) {
            lottoNos.add(i);
        }
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(lottoNos);
        List<Integer> result = lottoNos.subList(0, 6);
        Collections.sort(result);
        return result;
    }
}
