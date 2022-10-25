package lotto.domain;

public class LottoNumber {

    private final int value;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    private void validate(final int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d는 1~45 범위에 벗어난 숫자입니다.", number));
        }
    }

    public int getValue() {
        return value;
    }
}
