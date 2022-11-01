package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        Money money = new Money(InputView.insertMoney());
        int manualLottoCount = InputView.insertManualLottoCount();
        Lottos lottos = new Lottos(InputView.insertManualLotto(manualLottoCount));
        lottos.buyLottos(money.getBuyableLottoCount() - manualLottoCount);
        OutputView.printLottoCount(manualLottoCount, money.getBuyableLottoCount());
        OutputView.print(lottos.toString());
        WinningLotto winningLotto = new WinningLotto(InputView.insertWinningLotto(), InputView.insertBonusBall());
        LottoResult result = lottos.getResult(winningLotto);
        OutputView.printResult(result);
    }
}
