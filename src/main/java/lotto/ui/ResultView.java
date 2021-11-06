package lotto.ui;

import lotto.common.Constants;

/**
 * packageName : lotto.ui
 * fileName : OutputView
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class ResultView {
    private ResultView() {}

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static void print(InputType type) {
        System.out.println(type.isPurchase() ? Constants.MSG_INPUT_PURCHASE_PRICE : type.isNumber() ? Constants.MSG_INPUT_LAST_WINNING_NUMBERS : "");
    }
}
