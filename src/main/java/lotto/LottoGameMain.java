/*
 * LottoGameMain.java
 * v0.1
 * 2022.10.30
 */
package lotto;

public class LottoGameMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int payMoney = inputView.inputPay();
        LottoGame lottoGame = new LottoGame(payMoney, new LottoNumberAutoGenerator());

        int purchaseCount = lottoGame.getPurchaseCount();
        resultView.printResultPay(purchaseCount);

        PurchaseLottoNumber purchaseLottoNumber = new PurchaseLottoNumber(lottoGame.purchaseLotto(purchaseCount));
        resultView.printResultPurchase(purchaseLottoNumber);

        LottoNumbers winningNumbers = inputView.inputWinningNumberLastWeek();
        Statistic statistic = new Statistic(winningNumbers);
        statistic.countPrize(purchaseLottoNumber, inputView.inputBonusNumberLastWeek(winningNumbers));

        resultView.printResultWinningStatistics(payMoney, statistic);
    }
}
