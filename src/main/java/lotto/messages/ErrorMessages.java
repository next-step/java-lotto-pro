package lotto.messages;

public class ErrorMessages {
    private ErrorMessages() {
    }

    public static final String LOTTO_NUMBER_ERROR = "[ERROR] 로또 숫자는 1 ~ 45 사이의 숫자야 합니다.";
    public static final String LOTTO_NUMBERS_SIZE_ERROR = "[ERROR] 로또는 6개의 숫자야 합니다.";
    public static final String LOTTO_NUMBERS_DUPLICATION_ERROR = "[ERROR] 중복된 숫자는 불가 합니다.";

    public static final String MONEY_NEGATIVE_ERROR = "[ERROR] 금액은 양수여야 합니다.";
    public static final String ZERO_DIVIDE_ERROR = "[ERROR] 0으로 나눌수 없습니다.";

}
