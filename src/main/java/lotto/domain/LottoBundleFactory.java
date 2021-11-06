package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleFactory {

    private LottoBundleFactory() {
        throw new UnsupportedOperationException();
    }

    public static LottoBundle generateRandomLotto(int requestRandomLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < requestRandomLottoCount; i++) {
            lottos.add(new Lotto());
        }

        return new LottoBundle(lottos);
    }
}
