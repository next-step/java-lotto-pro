package lotto.view;

public class InputView {
    private static final String LOTTO_PURCHASE_GUIDE = "구입금액을 입력하세요.";
    private static final String WINNING_LOTTO_INPUT_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";

    public static void printPurchaseGuide() {
        System.out.println(LOTTO_PURCHASE_GUIDE);
    }

    public static void printWinningLottoInputGuide() {
        System.out.println(WINNING_LOTTO_INPUT_GUIDE);
    }
}

