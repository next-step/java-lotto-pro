package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int ZERO = 0;
    private final PlayerMoney playerMoney;

    private List<Lotto> lottos = new ArrayList<>();

    public Player(int money) {
        this(PlayerMoney.of(money));
    }
    public Player(PlayerMoney playerMoney) {
        this.playerMoney = playerMoney;
    }

    public LottoReport matchWinnerLotto(WinnerLotto winnerLotto) {
        return new LottoReport(lottoResult(winnerLotto));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void buyCustomLottos(List<Lotto> customLottos) {
        customLottos.forEach(this::buyCustomLotto);
    }

    public void buyCustomLotto(Lotto customLotto) {
        buyLotto(customLotto);
    }

    public void buyAutoLottos() {
        int buyAbleMaxLottoQty = playerMoney.buyAbleMaxLottoQty();
        for (int i = ZERO; i < buyAbleMaxLottoQty; i++) {
            buyLotto(Lotto.createAutoLotto());
        }
    }

    public boolean isBuyAble(int qty) {
        return  playerMoney.buyAbleMaxLottoQty() >= qty;
    }

    private void buyLotto(Lotto lotto) {
        playerMoney.deduction(Lotto.LOTTO_MONEY);
        this.lottos.add(lotto);
    }

    private List<LottoRank> lottoResult(WinnerLotto winnerLotto) {
        return this.lottos
                .stream()
                .map((winnerLotto::match))
                .collect(Collectors.toList());
    }



}
