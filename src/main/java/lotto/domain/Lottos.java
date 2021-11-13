package lotto.domain;

public class Lottos {
    private static final int MANUAL_LOTTO_COUNT_MINIMUM = 0;

    public Lottos(int totalLottoCount, int manualLottoCount) {
        validateManualLottoCount(totalLottoCount, manualLottoCount);
    }

    private void validateManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("수동 로또 개수는 총 구매한 로또 개수를 넘으면 안됩니다.");
        }
        if (manualLottoCount < MANUAL_LOTTO_COUNT_MINIMUM) {
            throw new IllegalArgumentException("수동 로또 개수는 0 이상이어야 합니다.");
        }
    }
}
