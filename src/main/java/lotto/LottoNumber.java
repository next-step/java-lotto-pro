package lotto;

public class LottoNumber {
    public static final String LOTTO_NUMBER_OUT_OF_BOUNDS_EXCEPTION_MESSAGE = "숫자가 정상적인 범위를 벗어납니다.";
    public static final int MAX = 45;
    public static final int MIN = 1;
    private final int value;

    public LottoNumber(int lottoNumber) {
        validateBounds(lottoNumber);
        this.value = lottoNumber;
    }

    private void validateBounds(int lottoNumber) {
        if (lottoNumber < MIN || lottoNumber > MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUNDS_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
