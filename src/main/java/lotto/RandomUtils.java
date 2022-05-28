package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoConst;

public class RandomUtils {
    public static Lotto createRandomLotto() {
        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = LottoConst.LOTTO_NO_START_NUMBER; i < LottoConst.LOTTO_NO_END_NUMBER; i++) {
            randomLottoNumbers.add(i);
        }

        Collections.shuffle(randomLottoNumbers);
        List<Integer> lottoNumbers = randomLottoNumbers.subList(0, LottoConst.LOTTO_NO_SIZE);
        Collections.sort(lottoNumbers);

        return Lotto.createRandomLotto(lottoNumbers);
    }
}
