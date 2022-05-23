package step3.lotto.domain.customer.wrap;

import java.util.Objects;

/**
 * @author : choi-ys
 * @date : 2022/05/22 4:34 오후
 */
public class ManualAttemptsCount {

    public static final String INVALID_MANUAL_ATTEMPTS_COUNT_RANGE_ERROR = "수동으로 진행할 로또 횟수는 입력한 금액 범위내에서 0보다 큰 수를 입력하세요.";

    private int manualAttemptsCount;

    private ManualAttemptsCount(int manualAttemptsCount) {
        this.manualAttemptsCount = manualAttemptsCount;
    }

    public static ManualAttemptsCount of(int manualAttemptsCount, Price price) {
        validateManualAttemptsCount(manualAttemptsCount, price);
        return new ManualAttemptsCount(manualAttemptsCount);
    }

    private static void validateManualAttemptsCount(int manualAttemptsCount, Price price) {
        if (manualAttemptsCount < 0 || manualAttemptsCount > price.calculateAttemptsCount()) {
            throw new IllegalArgumentException(INVALID_MANUAL_ATTEMPTS_COUNT_RANGE_ERROR);
        }
    }

    public int getManualAttemptsCount() {
        return manualAttemptsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ManualAttemptsCount that = (ManualAttemptsCount) o;
        return manualAttemptsCount == that.manualAttemptsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualAttemptsCount);
    }
}
