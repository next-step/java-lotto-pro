package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.View;

public class LottoController {
    private final Lottos lottos;
    private final View view;

    public LottoController() {
        this.lottos = new Lottos();
        this.view = new View();
    }

    public void run() {
        Money money = new Money(view.insertMoney());
        view.printLottoCount(money.getBuyableLottoCount());
        lottos.buyLottos(money.getBuyableLottoCount());
        view.print(lottos.toString());
        view.printResult(lottos.getResult(new WinningLotto(view.insertWinningLotto(), view.insertBonusBall())));
    }
}
