package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoMachine().run(InputView.console(), ResultView.console());
    }
}
