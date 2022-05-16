package lotto.domain;

public enum LottoNumberBounds {
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumberBounds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
