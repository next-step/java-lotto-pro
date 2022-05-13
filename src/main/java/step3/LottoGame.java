package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE_LOTTO = 1000;

    public static int ableToBuyLottoCount(int money) {
        return money / PRICE_LOTTO;
    }

    public List<Lotto> buy(int ableToBuyLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ableToBuyLottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public Lotto winnerLotto(List<Integer> winnerLottoNumbers) {
        return new Lotto(winnerLottoNumbers);
    }
}
