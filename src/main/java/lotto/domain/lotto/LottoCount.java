package lotto.domain.lotto;

import lotto.message.ErrorMessages;

public class LottoCount {
    private final int total;
    private final int manual;

    private LottoCount(int total, int manual) {
        this.total = total;
        this.manual = manual;
    }

    public static LottoCount of(int total, int manual) {
        validateTotal(total);
        validateManual(total, manual);
        return new LottoCount(total, manual);
    }

    private static void validateTotal(int total) {
        if (total < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASABLE_QUANTITY);
        }
    }

    private static void validateManual(int total, int manual) {
        if (manual < 0 || manual > total) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessages.INVALID_MANUAL_PURCHASABLE_QUANTITY, total));
        }
    }

    public int getAuto() {
        return total - manual;
    }

    public int getManual() {
        return this.manual;
    }

}
