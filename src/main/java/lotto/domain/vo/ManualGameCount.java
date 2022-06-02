package lotto.domain.vo;

import lotto.LottoMoneyChecker;

public class ManualGameCount {
    private final int count;

    public ManualGameCount(int count, int money) {
        LottoMoneyChecker.validateCountOfManualGame(count, money);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
