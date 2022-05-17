package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    public static void startLotto() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = InputView.enterNumber();
       

    }
}
