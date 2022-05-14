package lotto.view;

import lotto.lotto.Lotto;
import lotto.money.Money;

public interface InputView {

    static InputView console() {
        return new ConsoleInputView();
    }

    Money readMoney();

    Lotto readPreviousWinningLotto();
}
