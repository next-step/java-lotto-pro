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
        if(manualLottoCount > money.getBuyableLottoCount()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구매할 수 있는 로또 수보다 많습니다.");
        }
        Lottos lottos = new Lottos(InputView.insertManualLotto(manualLottoCount));
        lottos.buyLottos(money.getBuyableLottoCount() - manualLottoCount);
        OutputView.printLottoCount(manualLottoCount, money.getBuyableLottoCount());
        OutputView.print(lottos.toString());
        WinningLotto winningLotto = new WinningLotto(InputView.insertWinningLotto(), InputView.insertBonusBall());
        LottoResult result = lottos.getResult(winningLotto);
        OutputView.printResult(result);
    }
}
