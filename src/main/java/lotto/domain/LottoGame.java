package lotto.domain;

import lotto.ui.Input;
import lotto.ui.Output;
import lotto.ui.View;

public class LottoGame {

    private final View view;
    private final Lottos lottos;

    public LottoGame(Input input, Output output) {
        this.view = new View(input, output);
        lottos = new Lottos(new RandomNumberPickStrategy());
    }

    public void run() {
        Money money = new Money(view.insertMoney());
        view.printLottoSize(money.availableLottoSize());
        lottos.buyRandomNumberLottos(money.availableLottoSize());
        view.printText(lottos.toString());
        view.printResultStat(lottos.checkResultStat(
                new WinningLotto(view.insertWinningNumber(), view.insertBonusNumber())));
    }
}
