package lotto.model;

import java.util.Objects;

public class LottoCount {
    private static final String NEGATIVE_COUNT_ERR_MSG = "로또의 수는 음수일 수 없습니다.";
    private static final String MANUAL_COUNT_SIZE_ERR_MSG = "수동으로 구매하려고 하는 로또의 수가 총 로또의 수를 초과합니다.";

    private final int manualCount;
    private final int autoCount;

    public LottoCount(int manualCount, int totalCount) {
        validate(manualCount, totalCount);
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
    }

    private void validate(int manualCount, int totalCount) {
        if (manualCount < 0 || totalCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_COUNT_ERR_MSG);
        }
        if (manualCount > totalCount) {
            throw new IllegalArgumentException(MANUAL_COUNT_SIZE_ERR_MSG);
        }
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount)obj;
        return manualCount == that.manualCount && autoCount == that.autoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualCount, autoCount);
    }
}
