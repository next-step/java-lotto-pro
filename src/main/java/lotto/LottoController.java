package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        final int buyMoney = getBuyMoney();
        final Lottos lottos = generateLottos(buyMoney);
        final LottoTicket winTicket = getWinLottoTicket();
        printResult(lottos, winTicket);
    }

    private int getBuyMoney() {
        inputView.showEnterBuyMoneyMessage();
        return inputView.getBuyMoney();
    }

    private Lottos generateLottos(int buyMoney) {
        final int lottoCount = Lotto.getNumberOfLottosPurchasableWith(new Money(buyMoney));
        final Lottos lottos = Lottos.generateAuto(lottoCount);
        inputView.showLottoBoughtMessage(lottos);
        return lottos;
    }

    private LottoTicket getWinLottoTicket() {
        inputView.showEnterWinNumbersMessage();
        final List<Integer> inputNumbers = inputView.getWinNumbers();
        return LottoTicket.of(inputNumbers);
    }

    private void printResult(Lottos lottos, LottoTicket winTicket) {
        final LottoResult result = lottos.calculateWinning(winTicket);
        final double roi = result.getReturnOnInvestment(lottos.getSellingPrice());
        resultView.showWinningStatistics(result);
        resultView.showReturnOnInvestment(roi);
    }
}
