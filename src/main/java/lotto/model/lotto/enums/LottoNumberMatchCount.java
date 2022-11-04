package lotto.model.lotto.enums;

public enum LottoNumberMatchCount {
    THREE(3),
    FOUR(4),
    FIVE(4),
    SIX(4);

    private final int value;

    LottoNumberMatchCount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
