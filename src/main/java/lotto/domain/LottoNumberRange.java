package lotto.domain;

public enum LottoNumberRange {
    LOTTO_NUMBER_MIN_RANGE(1),
    LOTTO_NUMBER_MAX_RANGE(45);

    private final int range;

    LottoNumberRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
