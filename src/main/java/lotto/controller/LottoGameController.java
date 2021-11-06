package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {
    public void start() {
        InputView inputView = new InputView();

        Money inputMoney = inputView.inputMoney();
    }
}
