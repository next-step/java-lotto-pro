package nextstep.lotto.io;

import nextstep.lotto.domain.PurchaseLottoAmount;

import java.util.Scanner;

import static nextstep.lotto.constance.LottoDisplayMessage.PURCHASE_AMOUNT_MESSAGE;
import static nextstep.lotto.constance.LottoExceptionMessage.ERROR;
import static nextstep.lotto.constance.LottoExceptionMessage.INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE;

public class LottoDisplay {

    private static final Scanner scanner = new Scanner(System.in);

    public static PurchaseLottoAmount inputPurchaseAmount() {

        System.out.println(PURCHASE_AMOUNT_MESSAGE);

        try {
            String inputPurchaseAmount = scanner.nextLine();
            Integer purchaseAmount = Integer.valueOf(inputPurchaseAmount);
            return new PurchaseLottoAmount(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR + INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE);
            return inputPurchaseAmount();
        }
    }
}
