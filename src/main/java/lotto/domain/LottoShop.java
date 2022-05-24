package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private LottoShop() {
    }

    public static Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<count; i++) {
            lottos.add(LottoFactory.autoGenerator());
        }
        return new Lottos(lottos);
    }
}
