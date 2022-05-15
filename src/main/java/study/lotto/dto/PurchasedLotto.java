package study.lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.LottoNumbers;

public class PurchasedLotto {

    private final List<Integer> value;

    public PurchasedLotto(PurchasedLotto purchasedLotto) {
        this(purchasedLotto.value);
    }

    public PurchasedLotto(LottoNumbers lottoNumbers) {
        this(lottoNumbers.numbers());
    }

    public PurchasedLotto(List<Integer> lottoNumbers) {
        this.value = lottoNumbers.stream().map(Integer::new).collect(Collectors.toList());
    }

    public List<Integer> get() {
        return value;
    }
}
