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

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : target.getLottoNumbers()) {
            if (this.lottoNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
