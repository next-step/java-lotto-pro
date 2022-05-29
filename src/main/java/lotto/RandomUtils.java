package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class RandomUtils {
    public static Lotto createRandomLotto() {
        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = Lotto.LOTTO_NO_START_NUMBER; i < Lotto.LOTTO_NO_END_NUMBER; i++) {
            randomLottoNumbers.add(i);
        }

        Collections.shuffle(randomLottoNumbers);
        List<Integer> lottoNumbers = randomLottoNumbers.subList(0, Lotto.LOTTO_NO_SIZE);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
