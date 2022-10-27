package lotto;

import java.util.List;

public class LottoNumbers {
    private static final int MATCH = 1;
    private static final int NOT_MATCH = 0;
    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> values) {
        this.values = values;
    }

    public static LottoNumbers from(List<LottoNumber> values) {
        return new LottoNumbers(values);
    }

    public int matches(LottoNumbers lottoNumbers) {
        int matches = 0;
        for (LottoNumber lottoNumber : this.values) {
            matches += matchCount(lottoNumbers, lottoNumber);
        }
        return matches;
    }

    private int matchCount(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        if (lottoNumbers.matches(lottoNumber)) {
            return MATCH;
        }
        return NOT_MATCH;
    }

    public boolean matches(LottoNumber lottoNumber) {
        return this.values.contains(lottoNumber);
    }
}
