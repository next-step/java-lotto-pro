package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.LottoNumbersCache.values());

    private LottoFactory() {
    }

    public static Lotto createAuto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6));
    }

}
