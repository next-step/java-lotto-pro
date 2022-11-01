package lotto.view;

public class OutputView {
    private static final String STR_START_LOTTO = "구입금액을 입력해 주세요.";
    private static final String STR_WINNING_LOTTO_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String STR_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    
    public static void startLottoOutput() {
        print(STR_START_LOTTO);
    }

    public static void printWinningLottoNumOutput() {
        print(STR_WINNING_LOTTO_NUM);
    }
    
    public static void printBonusNumOutput() {
        print(STR_BONUS_BALL);
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
