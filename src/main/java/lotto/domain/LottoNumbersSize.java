package lotto.domain;

public enum LottoNumbersSize {
    LOTTO_NUMBERS_ZERO_SIZE(0),
    LOTTO_NUMBERS_SIZE(6);

    private final int size;

    LottoNumbersSize(int size) {
        this.size = size;
    }

    int getSize() {
        return size;
    }
}
