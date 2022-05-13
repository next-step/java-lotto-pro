package study.lotto.dto;

import java.util.List;
import study.lotto.domain.Lotto;

public class PurchasedLotto {

    private final List<Integer> lottoNumbers;

    public PurchasedLotto(Lotto lotto) {
        this(lotto.numbers());
    }

    public PurchasedLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
