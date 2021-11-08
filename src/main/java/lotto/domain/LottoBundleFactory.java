package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundleFactory {

    private LottoBundleFactory() {
        throw new UnsupportedOperationException();
    }

    public static LottoBundle generateRandomLotto(int requestRandomLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        LottoFactory lottoRandomFactory = new LottoRandomFactory();

        for (int i = 0; i < requestRandomLottoCount; i++) {
            lottos.add(new Lotto(lottoRandomFactory));
        }

        return new LottoBundle(lottos);
    }
}
