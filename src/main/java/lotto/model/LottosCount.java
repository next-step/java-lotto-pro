package lotto.model;

import lotto.view.ErrorMessage;

public class LottosCount {
    private final int total;
    private final int manual;

    public LottosCount(int total, int manual) {
        if (total - manual < 0) {
            throw new IllegalArgumentException(ErrorMessage.LACK_OF_MONEY);
        }
        this.total = total;
        this.manual = manual;
    }

    public int auto() {
        return total - manual;
    }

    public int getTotal() {
        return total;
    }

    public int getManual() {
        return manual;
    }
}
