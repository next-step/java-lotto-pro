package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
