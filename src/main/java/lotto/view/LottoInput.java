package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoInput {

    private LottoInput() {
    }

    public static int inputMoneyAndAvailableToPurchaseCount() {
        try {
            String input = InputConsole.inputMoneyForPurchaseLotto();
            Money money = new Money(input);
            return LottoCalculator.availableToPurchaseCount(money);
        } catch (IllegalArgumentException e) {
            OutputConsole.out(e.getMessage());
            return inputMoneyAndAvailableToPurchaseCount();
        }
    }

    public static WinningLotto inputWinningLotto() {
        try {
            String input = InputConsole.inputWinningLottoNumbers();
            return new WinningLotto(new Lotto(input));
        } catch (IllegalArgumentException e) {
            OutputConsole.out(e.getMessage());
            return inputWinningLotto();
        }
    }

}
