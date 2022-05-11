package lotto.controller;

import lotto.domain.Money;
import lotto.view.LottoInputView;

public class LottoController {
    private final LottoInputView lottoInputView;

    public LottoController() {
        this.lottoInputView = new LottoInputView();
    }

    public void play() {
        Money money = lottoInputView.inputMoney();
        System.out.println(String.format("money : %s", money.getMoney()));
    }
}
