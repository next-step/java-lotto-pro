package lotto.view;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    private OutputView() {
    }

    public static void printPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }
}
