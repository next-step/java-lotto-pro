package lotto.domain;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

}
