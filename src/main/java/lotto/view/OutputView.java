package lotto.view;

public class OutputView {
    private static final String STR_START_LOTTO = "구입금액을 입력해 주세요.";
    private static final String STR_WINNING_LOTTO_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    
    public static void startLottoOutput() {
        System.out.println(STR_START_LOTTO);
    }

    public static void printString(String str) {
        System.out.println(str);
    }

    public static void printWinningLottoNumOutput() {
        System.out.println(STR_WINNING_LOTTO_NUM);
    }
}
