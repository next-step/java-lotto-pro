package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int matches(List<LottoNumber> winningNumbers) {
        int matches = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            matches += matchCount(winningNumbers, lottoNumber);
        }
        return matches;
    }

    private int matchCount(List<LottoNumber> winningNumbers, LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            return MATCH;
        }
        return NOT_MATCH;
    }

    @Override
    public String toString() {
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }
}
