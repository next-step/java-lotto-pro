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
        final LottoNumbers winNumbers = getWinLottoNumbers();
        printResult(lottos, winNumbers);
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

    private LottoNumbers getWinLottoNumbers() {
        inputView.showEnterWinNumbersMessage();
        final List<Integer> inputNumbers = inputView.getWinNumbers();
        return LottoNumbers.of(inputNumbers);
    }

    private void printResult(Lottos lottos, LottoNumbers winNumbers) {
        final LottoResult lottoResult = lottos.calculateWinning(winNumbers);
        final double roi = lottoResult.getReturnOnInvestment(lottos.getSellingPrice());
        resultView.showWinningStatistics(lottoResult);
        resultView.showReturnOnInvestment(roi);
    }
}
