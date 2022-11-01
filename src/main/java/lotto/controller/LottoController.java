package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController() {
        this.view = new View();
    }

    public void run() {
        Money money = new Money(view.insertMoney());
        int manualLottoCount = view.insertManualLottoCount();
        Lottos lottos = new Lottos(view.insertManualLotto(manualLottoCount));
        lottos.buyLottos(money.getBuyableLottoCount() - manualLottoCount);
        view.printLottoCount(manualLottoCount, money.getBuyableLottoCount());
        view.print(lottos.toString());
        WinningLotto winningLotto = new WinningLotto(view.insertWinningLotto(), view.insertBonusBall());
        LottoResult result = lottos.getResult(winningLotto);
        view.printResult(result);
    }
}
