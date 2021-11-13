package lotto.ui;

import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;
import lotto.domain.Price;
import lotto.domain.Result;
import lotto.domain.Retailer;

public class LottoController {

    public static void run() {
        final String purchaseAmount = InputView.askPurchaseAmount();
        final Playslips playslips = Retailer.buy(new Price(purchaseAmount));
        ResultView.printPlayslips(playslips.size(), playslips.asString());

        final String pastWinningNumbers = InputView.askPastWinningNumbers();
        final Result result = playslips.checkResult(PickedNumbers.of(pastWinningNumbers));
        ResultView.printStats(result.asString(), result.calculateReturnOnInvestment());
    }
}
