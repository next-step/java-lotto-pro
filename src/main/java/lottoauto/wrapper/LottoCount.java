package lottoauto.wrapper;

public enum LottoCount {
    FIRST(6), SECOND(5), THIRD(4), FOURTH(3), FIFTH(2);

    private final int value;

    LottoCount(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
