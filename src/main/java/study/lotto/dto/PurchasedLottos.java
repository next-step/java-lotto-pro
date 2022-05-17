package study.lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.Lotto;

public class PurchasedLottos {

    private final List<PurchasedLotto> value;

    public PurchasedLottos(List<PurchasedLotto> purchasedLottos) {
        this.value = purchasedLottos.stream()
                .map(PurchasedLotto::new)
                .collect(Collectors.toList());
    }

    public static PurchasedLottos from(List<Lotto> lottos) {
        return new PurchasedLottos(
                lottos.stream()
                        .map(PurchasedLotto::new)
                        .collect(Collectors.toList()));
    }

    public List<PurchasedLotto> get() {
        return value;
    }
}
