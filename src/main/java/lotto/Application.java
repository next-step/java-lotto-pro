package lotto;

import lotto.domain.Lotties;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatus;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = Money.from(InputView.getPurchaseAmount());
        Lotties myLotties = LottoGame.purchase(purchaseAmount);
        ResultView.printPurchaseLotties(myLotties);
        String winningLottoNumber = InputView.getWinningLottoNumber();
        int bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        WinningStatus winningStatus = myLotties.getWinningStatus(winningLotto);
        ResultView.printWinningStatus(winningStatus);
        ResultView.printLottoYield(purchaseAmount, winningStatus);

    }
}
