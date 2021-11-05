package lotto.util;

public class LottoNumber {
    private final int number;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        validCheck(number);
        this.number = number;
    }

    private void validCheck(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자 범위가 아닙니다.");
        }
    }
}
