package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        final int buyMoney = inputView.getBuyMoney();
        final int manualCount = inputView.getManualCount();
        final List<String> manualLottoNumbers = inputView.getManualLottoNumbers(manualCount);

        final int totalCount = LottoTicket.countPurchasable(new Money(buyMoney));
        final Lottos lottos = new Lottos(totalCount, manualCount);
        lottos.generateManual(manualLottoNumbers);
        lottos.generateAuto();
        inputView.showLottoBoughtMessage(lottos);

        final WinTicket winTicket = inputView.getWinLottoTicket();

        final LottoResult result = lottos.calculateWinning(winTicket);
        final double roi = result.getReturnOnInvestment(lottos.calculateTotalSellingPrice());
        resultView.printResult(result, roi);
    }
}
