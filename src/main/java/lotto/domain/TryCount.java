package lotto.domain;

public class TryCount {

    private final int autoTryCount;
    private final int manualTryCount;

    public TryCount(int tryCount, int manualTryCount) {
        this.autoTryCount = tryCount - manualTryCount;
        this.manualTryCount = manualTryCount;
    }

    public int getAutoTryCount() {
        return autoTryCount;
    }

    public int getManualTryCount() {
        return manualTryCount;
    }
}
