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
        LottoGame lottoGame = new LottoGame(inputView.inputPay());

        int manualPurchaseCount = inputView.inputManualPurchase(lottoGame.getTotalMoney());

        inputView.printInputManualLottoNumber();
        PurchaseLottoNumbers purchaseLottoNumbers = new PurchaseLottoNumbers(
                lottoGame.manualPurchaseLotto(manualPurchaseCount));

        int autoPurchaseCount = lottoGame.getAutoPurchasableCount();
        resultView.printResultPay(autoPurchaseCount, manualPurchaseCount);

        purchaseLottoNumbers.addLottoNumbers(lottoGame.autoPurchaseLotto(autoPurchaseCount));
        resultView.printResultPurchase(purchaseLottoNumbers);

        LottoNumbers winningNumbers = inputView.inputWinningNumberLastWeek();
        Statistic statistic = new Statistic(winningNumbers);
        statistic.countPrize(purchaseLottoNumbers, inputView.inputBonusNumberLastWeek(winningNumbers));

        resultView.printResultWinningStatistics(lottoGame.getTotalMoney(), statistic);
    }
}
