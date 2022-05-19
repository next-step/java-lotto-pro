package lotto.domain;

public class LottosManualCount {
    private static final String MINUS_COUNT_MESSAGE = "음수를 입력할 수 없습니다.";
    private static final String MANUAL_LOTTO_COUNT_EXCEED_TOTAL_MESSAGE = "수동의 개수는 총 로또 개수를 초과할 수 없습니다.";
    private final int manualLottoCount;

    public LottosManualCount(final Price price, final int manualLottoCount) {
        checkManualLottoCountIsMinus(manualLottoCount);
        checkManualLottoCountExceedsTotalLottoCount(price, manualLottoCount);
        this.manualLottoCount = manualLottoCount;
    }

    private void checkManualLottoCountIsMinus(final int manualLottoCount) {
        if (isMinus(manualLottoCount)) {
            throw new IllegalArgumentException(MINUS_COUNT_MESSAGE);
        }
    }

    private boolean isMinus(final int manualLottoCount) {
        return manualLottoCount < 0;
    }

    private void checkManualLottoCountExceedsTotalLottoCount(final Price price, final int manualLottoCount) {
        if (isManualLottoCountExceedsTotalLottoCount(price, manualLottoCount)) {
            throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_EXCEED_TOTAL_MESSAGE);
        }
    }

    private boolean isManualLottoCountExceedsTotalLottoCount(final Price price, final int manualLottoCount) {
        return price.calculateLottoCount() < manualLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public boolean isManualLottoCountNotZero() {
        return getManualLottoCount() != 0;
    }
}
