package lotto.model;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;

    public WinningLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }
}
