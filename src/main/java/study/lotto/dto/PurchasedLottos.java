package study.lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.LottoNumbers;

public class PurchasedLottos {

    private final List<PurchasedLotto> value;

    public PurchasedLottos(List<PurchasedLotto> purchasedLottos) {
        this.value = purchasedLottos.stream()
                .map(PurchasedLotto::new)
                .collect(Collectors.toList());
    }

    public static PurchasedLottos from(List<LottoNumbers> lottoNumbers) {
        return new PurchasedLottos(
                lottoNumbers.stream()
                        .map(PurchasedLotto::new)
                        .collect(Collectors.toList()));
    }

    public List<PurchasedLotto> get() {
        return value;
    }
}
