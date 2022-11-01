/*
 * LottoGameMain.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.List;

public class LottoGameMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int payMoney = inputView.inputPay();
        LottoGame lottoGame = new LottoGame(payMoney, new AutoLottoNumberGenerator());

        int purchaseCount = lottoGame.getPurchaseCount();
        resultView.printResultPay(purchaseCount);

        List<LottoNumber> lottoNumbers = lottoGame.purchaseLotto(purchaseCount);
        resultView.printResultPurchase(lottoNumbers);

        Statistic statistic = new Statistic(new LottoNumber(inputView.inputWinningNumberLastWeek()));
        statistic.countPrize(lottoNumbers);

        resultView.printResultWinningStatistics(payMoney, statistic);
    }
}
