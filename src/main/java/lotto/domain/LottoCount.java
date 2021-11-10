package lotto.domain;

public class LottoCount {

    private final int totalCount;
    private final int manualCount;
    private final int autoCount;

    public LottoCount(int totalCount, int manualCount) {
        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
        check();
    }

    public LottoCount(Money money, int manualCount) {
        this(money.buy(), manualCount);
    }

    private void check() {
        if (this.autoCount < 0) {
            throw new IllegalArgumentException("자동 로또 개수는 음수가 될 수 없습니다.");
        }
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
