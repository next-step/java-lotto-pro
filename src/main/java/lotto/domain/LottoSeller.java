package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoSeller() {

    }

    public static List<Lotto> sellLottos(PurchaseAmount purchaseAmount) {
        int lottoTicketCount = purchaseAmount.getLottoTicketCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(getLotto(new AutoLottoCreateStrategy()));
        }
        return lottos;
    }

    private static Lotto getLotto(LottoCreateStrategy lottoCreateStrategy) {
        return lottoCreateStrategy.createLotto();
    }
}
