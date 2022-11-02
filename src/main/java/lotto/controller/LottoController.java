package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private Money money;
    private Lottos lottos;
    private WinningLotto winningLotto;

    public void run() {
        insertMoney();
        buyLottos();
        insertWinningLotto();
        printResult();
    }

    private void insertMoney() throws IllegalArgumentException {
        money = new Money(InputView.insertMoney());
    }

    private void buyLottos() throws IllegalArgumentException {
        int manualLottoCount = InputView.insertManualLottoCount();
        if (manualLottoCount > money.getBuyableLottoCount()) {
            OutputView.print("수동으로 구매할 로또 수가 구매할 수 있는 로또 수보다 많습니다.");
            buyLottos();
        }

        lottos = new Lottos(InputView.insertManualLotto(manualLottoCount));
        lottos.buyLottos(money.getBuyableLottoCount() - manualLottoCount);

        OutputView.printLottoCount(manualLottoCount, money.getBuyableLottoCount());
        OutputView.print(lottos.toString());
    }

    private void insertWinningLotto() throws IllegalArgumentException {
        winningLotto = new WinningLotto(InputView.insertWinningLotto(), InputView.insertBonusBall());
    }

    private void printResult() {
        LottoResult result = lottos.getResult(winningLotto);

        OutputView.printResult(result);
    }
}
