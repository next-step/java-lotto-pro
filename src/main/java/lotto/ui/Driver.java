package lotto.ui;

import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;

public class Driver {

    public static void run() {
        final String purchaseAmount = InputView.askPurchaseAmount();
        final Playslips playslips = InputView.purchaseLotto(purchaseAmount);
        final String pastWinningNumbers = InputView.askPastWinningNumbers();
        ResultView.printStats(playslips, PickedNumbers.of(pastWinningNumbers));
    }
}
