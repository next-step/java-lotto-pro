package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private LottoSeller() {
    }

    public static Lottos sellManualLottos(List<Lotto> manualLottos) {
        return new Lottos(manualLottos);
    }

    public static Lottos sellAutoLottos(int lottoTicketCount) {
        List<Lotto> autoLottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            autoLottos.add(getLotto(new AutoLottoCreateStrategy()));
        }
        return new Lottos(autoLottos);
    }

    public static Lottos integrationLottos(Lottos source, Lottos target) {
        source.addLottos(target);
        return source;
    }

    private static Lotto getLotto(LottoCreateStrategy lottoCreateStrategy) {
        return lottoCreateStrategy.createLotto();
    }
}
