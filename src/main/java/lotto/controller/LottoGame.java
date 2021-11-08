package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    private RandomNumbers randomNumbers;

    public LottoGame(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void start() {
        final Money money = LottoView.getMoney();
        final int manualCount = LottoView.getManualCount();

        final ManualLottos manualLottos = LottoView.getManualLottos(manualCount);
        final AutoLottos autoLottos = new AutoLottos(money, randomNumbers);
        final Lottos lottos = new Lottos(autoLottos, manualLottos);

        LottoView.displayCount(money);
        LottoView.displayLottos(lottos);

        final WinningLotto winningLotto = new WinningLotto(
                LottoView.getWinningNumbers(),
                LottoView.getBonusBall());
        final List<Rank> ranks = lottos.match(winningLotto);

        LottoView.displayStatic(new Result(ranks, money));
    }
}
