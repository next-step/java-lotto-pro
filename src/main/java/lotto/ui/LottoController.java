package lotto.ui;

import lotto.application.LottoResultChecker;
import lotto.application.LottoResultResponse;
import lotto.domain.Playslips;
import lotto.domain.Price;
import lotto.domain.Retailer;

public class LottoController {

    public static void run() {
        final String purchaseAmount = InputView.askPurchaseAmount();
        final Playslips playslips = Retailer.buy(new Price(purchaseAmount));
        ResultView.printPlayslips(playslips.size(), playslips.asString());

        final String pastWinningNumbers = InputView.askPastWinningNumbers();
        final LottoResultResponse resultResponse =
            LottoResultChecker.check(playslips, pastWinningNumbers);
        ResultView.printStats(resultResponse.asString());
    }
}
