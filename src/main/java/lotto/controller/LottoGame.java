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
        final Lottos lottos = new Lottos(money, randomNumbers);

        LottoView.displayCount(money);
        LottoView.displayLottos(lottos);

        final WinningLotto winningLotto = new WinningLotto(
                LottoView.getWinningNumbers(),
                LottoView.getBonusBall());
        final List<Rank> ranks = lottos.match(winningLotto);

        LottoView.displayStatic(new Result(ranks, money));
    }
}
