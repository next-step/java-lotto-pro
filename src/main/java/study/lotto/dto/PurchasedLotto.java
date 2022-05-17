package study.lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;

public class PurchasedLotto {

    private final List<Integer> value;

    public PurchasedLotto(PurchasedLotto purchasedLotto) {
        this(purchasedLotto.value);
    }

    public PurchasedLotto(Lotto lotto) {
        this(lotto.get().stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList()));
    }

    public PurchasedLotto(List<Integer> numbers) {
        this.value = new ArrayList<>(numbers);
    }

    public List<Integer> get() {
        return value;
    }
}
