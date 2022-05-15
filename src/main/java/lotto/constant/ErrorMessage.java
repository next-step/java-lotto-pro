package lotto.constant;

public class ErrorMessage {
    private static final String ERROR_HEAD = "[ERROR] ";

    public static final String LACK_MONEY = ERROR_HEAD + "로또 최소 가격은 1000원 입니다.";
    public static final String OVER_MONEY = ERROR_HEAD + "로또 구매 최대 가격은 10_000_000원 입니다.";
    public static final String INCORRECT_UNIT_MONEY = ERROR_HEAD + "구매 금액은 1000원 단위로 입력해주세요.";
    public static final String NOT_NUMBER = ERROR_HEAD + "숫자가 아닙니다.";
    public static final String NOT_LOTTO_NUMBER = ERROR_HEAD + "로또 번호는 1~45 사이의 숫자여야합니다.";
    public static final String CANT_CONVERT_MONEY = ERROR_HEAD + "구매금액 변환에 오류가 발생했습니다.";
    public static final String NON_SIX_NUMBERS = ERROR_HEAD + "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATION = ERROR_HEAD + "6개의 로또 번호에 중복이 있습니다.";
    public static final String DUPLICATION_BONUS = ERROR_HEAD + "보너스 번호가 이미 로또 번호에 존재합니다.";
    public static final String CONSTANT_CLASS = "Constant class";
    public static final String UTILITY_CLASS = "Utility class";

    private ErrorMessage() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }
}
