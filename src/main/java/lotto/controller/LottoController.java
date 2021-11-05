package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView = new InputView();
    
    public void start() {
        Money money = inputView.enterMoney();
    }
    
    

}
