package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.*;

public class LottoGame {

    public void play() {
        LottoMachine lottoMachine = readMoney();
        OutputView.printMessage(lottoMachine.calculatePurchaseLottos() + "개를 구매했습니다.");

        PurchasedLotto purchasedLotto = lottoMachine.purchaseLotto();
        OutputView.printMyLotto(purchasedLotto);

        Lotto lastWinningLotto = new Lotto(readLastWinningNumbers());
        LottoNo bonusNumber = new LottoNo(readBonusNumber());
        OutputView.printLine();

        LottoResult result = purchasedLotto.matchLottoNumbers(lastWinningLotto, bonusNumber);
        OutputView.showLottoResult(result, lottoMachine);
    }

    private LottoMachine readMoney() {
        String input = InputView.readUserInput(REQUEST_MONEY);
        return new LottoMachine(input);
    }

    private String readLastWinningNumbers() {
        return InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
    }

    private String readBonusNumber() {
        return InputView.readUserInput(REQUEST_BONUS_NUMBER);
    }
}
