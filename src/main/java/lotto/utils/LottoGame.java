package lotto.utils;

import lotto.view.InputView;

import java.io.IOException;

public class LottoGame {
    public void start() throws IOException {
        String amount = new InputView().printStart();
    }
}
