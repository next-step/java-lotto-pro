package lotto.ui;

import lotto.application.LottoPurchaseService;
import lotto.application.LottoResultChecker;
import lotto.application.LottoResultResponse;
import lotto.application.PlayslipsResponse;

public class LottoController {

    public static void run() {
        final String purchaseAmount = InputView.askPurchaseAmount();
        final PlayslipsResponse playslipsResponse = LottoPurchaseService.purchase(purchaseAmount);
        ResultView.printPlayslips(playslipsResponse.asString());

        final String pastWinningNumbers = InputView.askPastWinningNumbers();
        final String bonusNumber = InputView.askBonusNumber();
        final LottoResultResponse resultResponse = LottoResultChecker.check(
            playslipsResponse.getPlayslips(),
            pastWinningNumbers,
            bonusNumber
        );
        ResultView.printStats(resultResponse.asString());
    }
}
