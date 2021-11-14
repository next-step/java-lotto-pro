package lotto.view;

import lotto.exception.PurchaseAmountWrongFormatException;

public class LottoManualPurchaseCountView {

    private LottoManualPurchaseCountView() {
    }

    public static int input() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String purchaseAmountInput = Console.nextLine();

        return numberValid(purchaseAmountInput);
    }

    private static int numberValid(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new PurchaseAmountWrongFormatException();
        }
    }
}
