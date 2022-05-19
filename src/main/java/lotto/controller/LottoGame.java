package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.*;

public class LottoGame {

    public void play() {
        LottoMachine machine = readMoney();
        LottoQuantity manualQuantity = readQuantity();
        LottoQuantity automaticQuantity = getAutomaticQuantity(machine, manualQuantity);

        PurchasedLotto lottos = purchaseManualLotto(manualQuantity);
        PurchasedLotto automaticLottos = machine.purchaseLotto(automaticQuantity);

        printQuantityMessage(manualQuantity, automaticQuantity);
        lottos.append(automaticLottos);
        OutputView.printMyLotto(lottos);

        Lotto lastWinningLotto = new Lotto(readLastWinningNumbers());
        LottoNo bonusNumber = new LottoNo(readBonusNumber());
        OutputView.printLine();

        LottoResult result = lottos.matchLottoNumbers(lastWinningLotto, bonusNumber);
        OutputView.showLottoResult(result, machine);
    }

    private static void printQuantityMessage(LottoQuantity manualQuantity, LottoQuantity automaticQuantity) {
        OutputView.printMessage("수동으로 %d장, 자동으로 %d장 구매했습니다.\r\n",
                manualQuantity.getQuantity(), automaticQuantity.getQuantity());
    }

    private static PurchasedLotto purchaseManualLotto(LottoQuantity manualQuantity) {
        OutputView.printMessage("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualQuantity.getQuantity(); i++) {
            manualLottoList.add(new Lotto(InputView.readUserInput()));
        }
        OutputView.printLine();
        return new PurchasedLotto(manualLottoList);
    }

    public static LottoQuantity getAutomaticQuantity(LottoMachine machine, LottoQuantity manualQuantity) {
        LottoQuantity automaticQuantity = new LottoQuantity(machine.calculatePurchaseLottos() - manualQuantity.getQuantity());
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
