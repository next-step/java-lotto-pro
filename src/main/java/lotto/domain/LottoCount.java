package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

public class LottoCount {
    private final Money money;
    private final ManualCount manualCount;

    private LottoCount(Money money, ManualCount manualCount) {
        this.money = money;
        this.manualCount = manualCount;
    }

    public static LottoCount from(Money money, ManualCount manualCount) {
        int purchaseCount = money.purchaseCount();
        int count = manualCount.getCount();
        if (count < Constants.MIN_LOTTO_COUNT || count > purchaseCount) {
            throw new IllegalArgumentException(String.format(ErrorMessage.OUT_OF_RANGE_MANUAL_COUNT, purchaseCount));
        }
        return new LottoCount(money, manualCount);
    }

    public boolean isRemainingCount(int alreadyPurchaseCount) {
        return this.manualCount.isRemainingCount(alreadyPurchaseCount);
    }

    public int manualCount() {
        return this.manualCount.getCount();
    }

    public int autoCount() {
        return this.money.purchaseCount() - manualCount();
    }
}
