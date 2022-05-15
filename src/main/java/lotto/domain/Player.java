package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Lotto> lottos = new ArrayList<>();
    private static final int ZERO = 0;

    public Player(int money) {
        buyLotto(money);
    }

    private void buyLotto(int money) {
        int buyLottoQty = money / Lotto.LOTTO_MONEY;
        for (int i = ZERO; i < buyLottoQty; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
