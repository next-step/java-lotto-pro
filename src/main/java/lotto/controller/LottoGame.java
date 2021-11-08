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
        final LottoCount count = LottoView.getLottoCount(money);

        final Lottos lottos = getLottos(count);

        LottoView.displayCount(money);
        LottoView.displayLottos(lottos);

        final WinningLotto winningLotto = getWinningLotto();
        final List<Rank> ranks = lottos.match(winningLotto);

        LottoView.displayStatic(new Result(ranks, money));
    }

    private WinningLotto getWinningLotto() {
        final String winningNumbers = LottoView.getWinningNumbers();
        final Integer bonusBall = LottoView.getBonusBall();
        return new WinningLotto(winningNumbers, bonusBall);
    }

    private Lottos getLottos(LottoCount count) {
        final ManualLottos manualLottos = LottoView.getManualLottos(count);
        final AutoLottos autoLottos = new AutoLottos(count, randomNumbers);
        return new Lottos(autoLottos, manualLottos);
    }
}
