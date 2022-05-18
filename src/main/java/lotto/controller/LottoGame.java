package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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

        LottoResult result = matchLottoNumbers(purchasedLotto, lastWinningLotto, bonusNumber);
        OutputView.showLottoResult(result, lottoMachine);
    }

    public LottoResult matchLottoNumbers(PurchasedLotto purchasedLotto, Lotto lastWinningLotto, LottoNo bonusNumber) {
        List<Ranking> rankings = purchasedLotto.compareLottos(lastWinningLotto, bonusNumber);
        return new LottoResult(rankings);
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
