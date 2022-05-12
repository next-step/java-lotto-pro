package lotto.lotto;

class LottoNumber {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int value;

    protected LottoNumber(String value) {
        throw new RuntimeException("create");
    }

    protected LottoNumber(int value) {
        throw new RuntimeException("create");
    }

    public static LottoNumber of(String value) {
        return new LottoNumber(value);
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }
}
