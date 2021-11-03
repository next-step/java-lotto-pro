package lotto;

import view.ResultView;

public class Lotto {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public void start() {
        ResultView.print(ASK_PURCHASE_AMOUNT);
    }
}
