package study.lotto.dto;

import java.util.List;
import java.util.Objects;

public class PurchasedLotto {

    private final List<Integer> lottoNumbers;

    public PurchasedLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
