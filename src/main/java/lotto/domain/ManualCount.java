package lotto.domain;

import lotto.exception.ManualCountException;

public class ManualCount {
    private int manualCount;

    public ManualCount(int count) {
        this.manualCount = count;
        validation();
    }

    private void validation() {
        if (manualCount < 0) {
            throw new ManualCountException();
        }
    }

    public boolean isHigherThanBoughtCount(int boughtCount) {
        return manualCount > boughtCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
