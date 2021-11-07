package lotto.view;

import lotto.domain.LottoIssuanceCount;
import lotto.exception.ErrorMessage;
import lotto.exception.PurchaseAmountWrongFormatException;

public class LottoPurchaseView {

    private LottoPurchaseView() {
    }

    public static int input() {
        System.out.println("구입금액을 입력해주세요.");
        String purchaseAmountInput = Console.nextLine();

        int purchaseAmount = numberValid(purchaseAmountInput);
        purchaseAmountRangeValid(purchaseAmount);

        return purchaseAmount;
    }

    private static int numberValid(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new PurchaseAmountWrongFormatException();
        }
    }

    private static void purchaseAmountRangeValid(int purchaseAmount) {
        if (purchaseAmount < LottoIssuanceCount.LOTTO_PRICE || purchaseAmount % LottoIssuanceCount.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON.getMessage());
        }
    }

}
