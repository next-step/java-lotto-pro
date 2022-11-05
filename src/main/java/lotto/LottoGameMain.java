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

        PurchaseQuantity manualPurchaseQuantity = new PurchaseQuantity(
                inputView.inputManualPurchase(lottoGame.getAmount()));

        inputView.printInputManualLottoNumber();
        PurchaseLottoNumbers purchaseLottoNumbers = new PurchaseLottoNumbers(
                lottoGame.manualPurchaseLotto(manualPurchaseQuantity));

        PurchaseQuantity autoPurchaseQuantity = new PurchaseQuantity(lottoGame.getPurchase());
        resultView.printResultPay(autoPurchaseQuantity, manualPurchaseQuantity);

        purchaseLottoNumbers.addLottoNumbers(lottoGame.autoPurchaseLotto(autoPurchaseQuantity));
        resultView.printResultPurchase(purchaseLottoNumbers);

        LottoNumbers winningNumbers = inputView.inputWinningNumberLastWeek();
        Statistic statistic = new Statistic(winningNumbers);
        statistic.countPrize(purchaseLottoNumbers, inputView.inputBonusNumberLastWeek(winningNumbers));

        resultView.printResultWinningStatistics(lottoGame.getAmount(), statistic);
    }
}
