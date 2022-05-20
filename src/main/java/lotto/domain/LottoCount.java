package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private final int auto;
    private final int manual;

    public LottoCount(int auto, int manual) {
        if (auto < 0 || manual < 0) {
            throw new IllegalArgumentException("구매횟수 음수가 될 수 없습니다.");
        }
        this.auto = auto;
        this.manual = manual;
    }

    public LottoCount(double autoNumber, int manualNumber) {
        this((int) autoNumber, manualNumber);
    }

    public static LottoCount of(double autoNumber, int manualNumber) {
        return new LottoCount(autoNumber, manualNumber);
    }

    public int getAuto() {
        return auto;
    }

    public int getManual() {
        return manual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return getAuto() == that.getAuto() && getManual() == that.getManual();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuto(), getManual());
    }
}

