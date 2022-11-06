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

        Quantity manualQuantity = Quantity.from(inputView.inputManualPurchase());
        lottoGame.isPurchase(manualQuantity);

        inputView.printInputManualLottoNumber();
        PurchaseLottoNumbers purchaseLottoNumbers = new PurchaseLottoNumbers(
                lottoGame.manualPurchaseLotto(manualQuantity));

        Quantity autoQuantity = Quantity.from(lottoGame.getPurchase());
        resultView.printResultPay(autoQuantity, manualQuantity);

        purchaseLottoNumbers.addLottoNumbers(lottoGame.autoPurchaseLotto(autoQuantity));
        resultView.printResultPurchase(purchaseLottoNumbers);

        LottoNumbers winningNumbers = inputView.inputWinningNumberLastWeek();
        Statistic statistic = new Statistic(winningNumbers);
        statistic.countPrize(purchaseLottoNumbers, inputView.inputBonusNumberLastWeek(winningNumbers));

        resultView.printResultWinningStatistics(lottoGame.getAmount(), statistic);
    }
}
