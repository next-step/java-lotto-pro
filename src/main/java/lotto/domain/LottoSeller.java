package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoSeller() {

    }

    public static List<Lotto> sellLottos(PurchaseAmount purchaseAmount, List<Lotto> manualLottos) {
        int lottoTicketCount = purchaseAmount.getLottoTicketCount();
        int manualLottoTicketCount = manualLottos.size();
        List<Lotto> lottos = new ArrayList<>(manualLottos);
        for (int i = 0; i < lottoTicketCount - manualLottoTicketCount; i++) {
            lottos.add(getLotto(new AutoLottoCreateStrategy()));
        }
        return lottos;
    }

    private static Lotto getLotto(LottoCreateStrategy lottoCreateStrategy) {
        return lottoCreateStrategy.createLotto();
    }
}
