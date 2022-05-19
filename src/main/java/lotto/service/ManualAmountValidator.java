package lotto.service;

import static lotto.domain.message.ErrorMessage.INVALID_MANUAL_AMOUNT;

public class ManualAmountValidator {
    public static void validate(final int manualAmount, final int purchasableAmount) {
        if (manualAmount < 0 || manualAmount > purchasableAmount) {
            throw new IllegalArgumentException(INVALID_MANUAL_AMOUNT.getMessage());
        }
    }
}
