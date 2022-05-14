package lotto;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningStatus;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = Money.from(InputView.getPurchaseAmount());
        Lotties myLotties = LottoGame.purchase(purchaseAmount);
        ResultView.printPurchaseLotties(myLotties);
        Lotto winningLotto = Lotto.create(InputView.getWinningLotto());
        WinningStatus winningStatus = myLotties.getWinningStatus(winningLotto);
        ResultView.printWinningStatus(winningStatus);

    }
}
