package lotto.domain;

import lotto.LottoGame;

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

    public static LottoCount of(Money purchaseAmount, int manualLottoCount) {
        if (purchaseAmount.divide(LottoGame.LOTTO_PRICE) < manualLottoCount) {
            throw new IllegalArgumentException("구입금액보다 많은 로또를 수동으로 구매할 수 없습니다.");
        }

        return new LottoCount((int) purchaseAmount.divide(LottoGame.LOTTO_PRICE) - manualLottoCount, manualLottoCount);
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

