package lotto.domain;

public enum LottoNumberRange {
    LOTTO_NUMBER_MIN_RANGE(1),
    LOTTO_NUMBER_MAX_RANGE(45);

    private final int range;

    LottoNumberRange(int range) {
        this.range = range;
    }

    public static boolean isBetween(int number) {
        return number >= LOTTO_NUMBER_MIN_RANGE.getRange() && number <= LOTTO_NUMBER_MAX_RANGE.getRange();
    }

    public int getRange() {
        return range;
    }
}
