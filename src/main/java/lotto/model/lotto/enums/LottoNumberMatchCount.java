package lotto.model.lotto.enums;

public enum LottoNumberMatchCount {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoNumberMatchCount(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
