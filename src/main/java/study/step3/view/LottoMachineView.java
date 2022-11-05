package study.step3.view;

import study.step3.domain.lotto.PurchaseMoney;
import study.step3.message.LottoMachineMessage;
import study.step3.util.Patterns;

public class LottoMachineView {

    private static final long PURCHASE_MINIMUM_MONEY = 1000;

    public static PurchaseMoney getPurchaseMoney() {
        PurchaseMoney purchaseMoney = null;
        while (isNeedToInputPurchaseMoney(purchaseMoney)) {
            ResultView.output(LottoMachineMessage.INPUT_PURCHASE_MONEY_MESSAGE.message());
            purchaseMoney = inputPurchaseMoney();
        }
        return purchaseMoney;
    }

    private static boolean isNeedToInputPurchaseMoney(PurchaseMoney purchaseMoney) {
        return purchaseMoney == null;
    }

    private static PurchaseMoney inputPurchaseMoney() {
        try {
            String purchaseMoney = InputView.input();
            validatePurchaseMoney(purchaseMoney);
            return PurchaseMoney.of(Long.parseLong(purchaseMoney));
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validatePurchaseMoney(String purchaseMoney) {
        validatePurchaseMoneyIsNotEmpty(purchaseMoney);
        validatePurchaseMoneyIsNumber(purchaseMoney);
        validatePurchaseMoneyIsGreaterThanMinimumMoney(purchaseMoney);
    }

    private static void validatePurchaseMoneyIsNotEmpty(String purchaseMoney) {
        if(purchaseMoney == null || purchaseMoney.isEmpty()) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_SHOULD_BE_NOT_EMPTY.message());
        }
    }

    private static void validatePurchaseMoneyIsNumber(String purchaseMoney) {
        if(!Patterns.ONLY_NUMBERS.match(purchaseMoney)) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_SHOULD_BE_NUMBER.message());
        }
    }

    private static void validatePurchaseMoneyIsGreaterThanMinimumMoney(String purchaseMoney) {
        if(Long.parseLong(purchaseMoney) < PURCHASE_MINIMUM_MONEY) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_IS_GREATER_THAN_MINIMUM_MONEY.message());
        }
    }
}
