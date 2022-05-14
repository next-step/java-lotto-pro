package lotto.view;

import lotto.lotto.WinningLotto;
import lotto.money.Money;

public interface InputView {

    static InputView console() {
        return new ConsoleInputView();
    }

    Money readMoney();

    WinningLotto readPreviousWinningLotto();
}
