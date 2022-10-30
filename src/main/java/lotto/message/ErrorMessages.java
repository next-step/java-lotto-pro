package lotto.message;

public class ErrorMessages {
    public static final String INVALID_LOTTO_NUMBER = "%d(은)는 1 ~ 45 범위에 벗어난 숫자입니다.";
    public static final String INVALID_PURCHASE_PRICE = "%s원은 로또 1장을 구입할 수 없는 금액입니다.";
    public static final String DUPLICATED_LOTTO_NUMBERS = "%s는 중복된 로또 번호가 존재합니다.";
    public static final String INVALID_LOTTO_NUMBERS_COUNT = "%s는 로또 번호가 6개가 아닙니다.";
    public static final String INVALID_MATCH_COUNT = "%d(은)는 유효하지 않은 일치 숫자입니다.";
    public static final String INVALID_LOTTO_NUMBERS = "%s(은)는 유효하지 않은 당첨번호입니다.";
    public static final String INVALID_BONUS_NUMBER = "%s(은)는 유효하지 않은 보너스 번호입니다.";
    public static final String DUPLICATED_BONUS_NUMBER = "%s(은)는 당첨번호와 중복된 숫자입니다.";
    public static final String INVALID_PURCHASABLE_QUANTITY = "로또 구매 수량은 음수일 수 없습니다.";
    public static final String INVALID_MANUAL_PURCHASABLE_QUANTITY = "수동으로 구매할 수 있는 수량은 0 ~ %d 사이 입니다.";

    private ErrorMessages() {
    }
}
