package lotto.domain;

import lotto.exception.ManualCountException;

import static lotto.common.LottoConst.LOTTO_PRICE;

public class BoughtLotto {
    private final BoughtMoney boughtMoney;
    private final ManualCount manualCount;

    private BoughtLotto(final String boughtMoney, final String manualCount) {
        this.boughtMoney = new BoughtMoney(Integer.parseInt(boughtMoney));
        this.manualCount = new ManualCount(Integer.parseInt(manualCount));
        validation();
    }

    public static BoughtLotto of(final String boughtMoney, final String manualCount) {
        return new BoughtLotto(boughtMoney, manualCount);
    }

    private void validation() {
        if (manualCount.isHigherThanBoughtCount(getBoughtCount())) {
            throw new ManualCountException();
        }
    }

    private int getBoughtCount() {
        return this.boughtMoney.getMoney() / LOTTO_PRICE;
    }

    public int getBoughtMoney() {
        return boughtMoney.getMoney();
    }

    public int getManualCount() {
        return manualCount.getManualCount();
    }

    public int getAutoCount() {
        return getBoughtCount() - getManualCount();
    }
}
