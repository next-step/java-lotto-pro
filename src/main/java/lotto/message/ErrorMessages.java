package lotto.message;

public class ErrorMessages {
    public static final String INVALID_LOTTO_NUMBER = "%d(은)는 1 ~ 45 범위에 벗어난 숫자입니다.";
    public static final String INVALID_PURCHASE_PRICE = "%s원은 로또 1장을 구입할 수 없는 금액입니다.";
    public static final String DUPLICATED_LOTTO_NUMBERS = "%s는 중복된 로또 번호가 존재합니다.";
    public static final String INVALID_LOTTO_NUMBERS_COUNT = "%s는 로또 번호가 6개가 아닙니다.";

    private ErrorMessages() {
    }
}
