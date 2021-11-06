package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> purchasedLottos;

    public LottoBundle(List<Lotto> lottos) {
        this.purchasedLottos = lottos;
    }

    public int getLottoCount() {
        return purchasedLottos.size();
    }
}
