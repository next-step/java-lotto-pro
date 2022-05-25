package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private LottoShop() {
    }

    public static Lottos generateLottos(Money money, List<String> inputManualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String s : inputManualLottoNumbers) {
            lottos.add(LottoFactory.manualGenerator(s));
        }
        for (int i=0; i<money.getAutoCount(); i++) {
            lottos.add(LottoFactory.autoGenerator());
        }
        return new Lottos(lottos);
    }
}
