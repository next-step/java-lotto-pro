package lotto.domain;

public enum LottoAmountUnit {
    LOTTO_AMOUNT_UNIT(1000),
    LOTTO_AMOUNT_UNIT_MODULO(0),
    PROFIT_RATIO_SCALE(100);

    private final int unit;

    LottoAmountUnit(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
