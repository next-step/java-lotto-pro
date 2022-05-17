package lotto.domain;

import static lotto.common.Messages.PASSIVE_COUNT_NOT_NUMBER;
import static lotto.common.Messages.PASSIVE_COUNT_OUT;
import static lotto.utils.NumberUtil.isNumber;

public class LottoPassiveCount {
    private final int gameCount;
    private final int passiveCount;

    public LottoPassiveCount(int gameCount, String passiveCountString) {
        validateNumber(passiveCountString);
        this.gameCount = gameCount;
        this.passiveCount = Integer.parseInt(passiveCountString);

        validateGameCount();
    }

    private void validateNumber(String money) {
        if (!isNumber(money)) {
            throw new IllegalArgumentException(PASSIVE_COUNT_NOT_NUMBER);
        }
    }

    private void validateGameCount() {
        if (gameCount < passiveCount) {
            throw new IllegalArgumentException(PASSIVE_COUNT_OUT);
        }
    }

    public int getPassiveCount() {
        return passiveCount;
    }
}
