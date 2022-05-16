package lotto.view;

public final class LottoInputView {
    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력하세요.";
    private static final String MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또의 수를 입력 주세요.";
    private static final String MANUAL_NUMBER_MESSAGE = "수동으로 구매할 로또번호를 입력 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private LottoInputView() {
    }

    public static void printLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printManualPurchaseCount() {
        System.out.println(MANUAL_PURCHASE_COUNT_MESSAGE);
    }

    public static void printManualNumber() {
        System.out.println(MANUAL_NUMBER_MESSAGE);
    }

    public static void printWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
