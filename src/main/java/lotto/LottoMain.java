package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseMoney = InputView.getPurchaseMoney();
        Lotto lotto = new Lotto(purchaseMoney);
        ResultView.printPurchaseNumbers(lotto.getPurchaseLottoList());
        String winningNumbers = InputView.getWinningNumbers();
    }
}
