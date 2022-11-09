package lotto;

import java.util.Collections;
import java.util.stream.Collectors;

import static lotto.common.Constants.LOTTO_LENGTH;
import static lotto.common.Constants.LOTTO_MAX_NUM;
import static lotto.common.Constants.LOTTO_MIN_NUM;

public class LottoGenerator {
    private static LottoNumbers lottoNumbers = new LottoNumbers();

    static {
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }

    public static Lotto generateLotto() {
        Collections.shuffle(lottoNumbers.LottoNumbersToListOfLottoNumber());
        return new Lotto(lottoNumbers.LottoNumbersToListOfLottoNumber().stream()
                .limit(LOTTO_LENGTH)
                .collect(Collectors.toList()));
    }
}
