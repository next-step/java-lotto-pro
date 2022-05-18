package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.InputView.*;

public class LottoGame {

    public void play() {
        LottoMachine machine = readMoney();
        LottoQuantity manualQuantity = readQuantity();
        LottoQuantity automaticQuantity = getAutomaticQuantity(machine, manualQuantity);

        PurchasedLotto purchasedLotto = machine.purchaseLotto();
        OutputView.printMyLotto(purchasedLotto);

        Lotto lastWinningLotto = new Lotto(readLastWinningNumbers());
        LottoNo bonusNumber = new LottoNo(readBonusNumber());
        OutputView.printLine();

        LottoResult result = purchasedLotto.matchLottoNumbers(lastWinningLotto, bonusNumber);
        OutputView.showLottoResult(result, machine);
    }

    public static LottoQuantity getAutomaticQuantity(LottoMachine machine, LottoQuantity manualQuantity) {
        LottoQuantity automaticQuantity = new LottoQuantity(machine.calculatePurchaseLottos() - manualQuantity.getQuantity());
        machine.minusMoney(automaticQuantity);
        return automaticQuantity;
    }

    private static LottoMachine readMoney() {
        LottoMachine machine = new LottoMachine(InputView.readUserInput(REQUEST_MONEY));
        OutputView.printLine();
        return machine;
    }

    private LottoQuantity readQuantity() {
        LottoQuantity quantity = new LottoQuantity(InputView.readUserInput(REQUEST_PASSIVE_LOTTO_QUANTITY));
        OutputView.printLine();
        return quantity;
    }

    private String readLastWinningNumbers() {
        return InputView.readUserInput(REQUEST_LAST_WINNING_NUMBERS);
    }

    private String readBonusNumber() {
        return InputView.readUserInput(REQUEST_BONUS_NUMBER);
    }
}
