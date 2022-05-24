package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean isMatch(LottoNumber lottoNumber) {
        boolean result = false;
        if (this.lottoNumbers.contains(lottoNumber)) {
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
