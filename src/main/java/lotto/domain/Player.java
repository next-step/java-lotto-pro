package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int ZERO = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    public Player(List<Lotto> customLottos) {
        buyCustomLotto(customLottos);
    }

    public Player(int money) {
        buyAutoLotto(money);
    }

    public LottoReport matchWinnerLotto(Lotto winnerLotto) {
        return new LottoReport(lottoResult(winnerLotto));
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    private void buyCustomLotto(List<Lotto> customLottos) {
        lottos.addAll(customLottos);
    }

    private void buyAutoLotto(int money) {
        int buyLottoQty = money / Lotto.LOTTO_MONEY;
        for (int i = ZERO; i < buyLottoQty; i++) {
            lottos.add(new Lotto());
        }
    }

    private List<LottoRank> lottoResult(Lotto winnerLotto) {
        return this.lottos
                .stream()
                .map((winnerLotto::match))
                .collect(Collectors.toList());
    }


}
