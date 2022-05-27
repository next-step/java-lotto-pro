package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class RandomUtils {
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_COUNT = 6;

    public static Lotto createRandomLotto() {
        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            randomLottoNumbers.add(i);
        }

        Collections.shuffle(randomLottoNumbers);
        List<Integer> lottoNumbers = randomLottoNumbers.subList(0, LOTTO_COUNT);
        Collections.sort(lottoNumbers);

        return Lotto.createRandomLotto(lottoNumbers);
    }
}
