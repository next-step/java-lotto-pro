package lotto.controller;

import lotto.domain.*;
import lotto.view.Error;
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
            OutputView.print(Error.CANNOT_BUY);
            buyLottos();
        }

        lottos = new Lottos(InputView.insertManualLotto(manualLottoCount));
        lottos.buyLottos(money.getBuyableLottoCount() - manualLottoCount);

        OutputView.printLottoCount(manualLottoCount, money.getBuyableLottoCount());
        OutputView.print(lottos.toString());
    }

    private void insertWinningLotto() throws IllegalArgumentException {
        List<LottoNumber> winningLottoNumbers = InputView.insertWinningLotto();
        LottoNumber bonusBall;

        do {
            bonusBall = InputView.insertBonusBall();
        } while(!LottoValidator.isValidWinningLotto(winningLottoNumbers, bonusBall));

        winningLotto = new WinningLotto(winningLottoNumbers, bonusBall);
    }

    private void printResult() {
        LottoResult result = lottos.getResult(winningLotto);

        OutputView.printResult(result);
    }
}
