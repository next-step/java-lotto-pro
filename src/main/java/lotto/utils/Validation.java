package lotto.utils;

import lotto.view.OutputView;

public class Validation {
    private static final int LOTTO_PRICE = 1000;

    public static void isValidCount(int amount) {
        if (amount < 0) {
            OutputView.printErrorMessage();
        }
        if (amount % LOTTO_PRICE > 0) {
            OutputView.printErrorMessage();
        }
    }
}
