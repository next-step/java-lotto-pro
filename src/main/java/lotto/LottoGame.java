package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        final int buyMoney = inputView.getBuyMoney();

        final int lottoCount = LottoTicket.countPurchasable(new Money(buyMoney));
        final Lottos lottos = Lottos.generateAuto(lottoCount);
        inputView.showLottoBoughtMessage(lottos);

        final WinTicket winTicket = inputView.getWinLottoTicket();

        final LottoResult result = lottos.calculateWinning(winTicket);
        final double roi = result.getReturnOnInvestment(lottos.getSellingPrice());
        resultView.printResult(result, roi);
    }
}
