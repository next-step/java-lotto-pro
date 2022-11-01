package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoSeller() {

    }

    public static Lottos sellLottos(PurchaseAmount purchaseAmount) {
        int lottoTicketCount = purchaseAmount.getLottoTicketCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(LottoMachine.getLotto(new AutoLottoCreateStrategy()));
        }
        return new Lottos(lottos);
    }
}
