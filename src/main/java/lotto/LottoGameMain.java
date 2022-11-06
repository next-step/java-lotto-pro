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
        Lottos lottos = new Lottos(
                lottoGame.manualPurchaseLotto(manualQuantity));

        Quantity autoQuantity = Quantity.from(lottoGame.getPurchase());
        resultView.printResultPay(autoQuantity, manualQuantity);

        lottos.addLottoNumbers(lottoGame.autoPurchaseLotto(autoQuantity));
        resultView.printResultPurchase(lottos);

        Lotto winningNumbers = inputView.inputWinningNumberLastWeek();
        LottoNumber bonus = inputView.inputBonusNumberLastWeek();
        winningNumbers.isContainsBonus(bonus);

        Statistic statistic = new Statistic(winningNumbers, bonus);
        statistic.countPrize(lottos);
        resultView.printResultWinningStatistics(lottoGame.getAmount(), statistic);
    }
}
