package lotto.ui;

import lotto.application.LottoPurchaseService;
import lotto.application.LottoResultChecker;
import lotto.application.LottoResultResponse;
import lotto.application.PlayslipsResponse;

public class LottoController {

    public static void run() {
        final String purchaseAmount = InputView.askPurchaseAmount();
        final int numberOfManualPlayslips = getNumberOfManualPlayslips();
        final PlayslipsResponse playslipsResponse = LottoPurchaseService.purchase(
            purchaseAmount,
            InputView.askEnterNumbers(numberOfManualPlayslips)
        );
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

    private static int getNumberOfManualPlayslips() {
        int numberOfManualPlayslips;
        try {
            numberOfManualPlayslips = Integer.parseInt(InputView.askNumberOfManuals());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수를 올바르게 입력해주세요.");
        }
        return numberOfManualPlayslips;
    }
}
