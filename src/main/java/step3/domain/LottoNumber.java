package step3.domain;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static final String ERROR_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45의 숫자입니다.";

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
        checkNumberRange();
    }

    private void checkNumberRange() {
        if (!(this.number >= MIN_NUMBER && this.number <= MAX_NUMBER)) {
            throw new IllegalArgumentException(ERROR_RANGE_NUMBER);
        }
    }
}
