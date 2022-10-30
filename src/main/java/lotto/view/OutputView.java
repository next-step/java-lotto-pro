package lotto.view;

import lotto.util.Constants;

public class OutputView {
    public static void startLottoOutput() {
        System.out.println(Constants.STR_START_LOTTO);
    }

    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void getWinningLottoNumOutput() {
        System.out.println(Constants.STR_WINNING_LOTTO_NUM);
    }
}
