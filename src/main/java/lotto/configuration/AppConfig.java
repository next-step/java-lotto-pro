package lotto.configuration;

import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class AppConfig {

    private AppConfig() {

    }

    public static InputView inputView() {
        return new ConsoleInputView();
    }

    public static ResultView resultView() {
        return new ConsoleResultView();
    }
}
