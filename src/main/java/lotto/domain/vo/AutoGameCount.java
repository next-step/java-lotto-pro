package lotto.domain.vo;


import static lotto.config.LottoGameConfig.PURCHASE_MONEY;

public class AutoGameCount {
    private final int count;

    public AutoGameCount(ManualGameCount manualGameCount, int money) {
        int change = money - (manualGameCount.getCount() * PURCHASE_MONEY);
        this.count = Math.max(change / PURCHASE_MONEY, 0);
    }

    public int getCount() {
        return count;
    }
}
