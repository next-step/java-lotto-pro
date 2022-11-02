package step3.configuration;

import step3.ui.ConsoleInputView;
import step3.ui.ConsoleResultView;
import step3.ui.InputView;
import step3.ui.ResultView;

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
