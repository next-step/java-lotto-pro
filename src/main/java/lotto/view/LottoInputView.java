package lotto.view;

public final class LottoInputView {
    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력하세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private LottoInputView() {
    }

    public static void printPurchase() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }
}
