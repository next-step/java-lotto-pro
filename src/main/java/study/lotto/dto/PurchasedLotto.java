package study.lotto.dto;

import java.util.List;
import study.lotto.domain.LottoNumbers;

public class PurchasedLotto {

    private final List<Integer> lottoNumbers;

    public PurchasedLotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers.numbers());
    }

    public PurchasedLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
