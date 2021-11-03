package lotto.constant;

public class ErrorMessage {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static final String INVALID_LOTTO_NUMBER = ERROR_PREFIX + "로또 숫자는 1~45 사이의 숫자이어야 합니다. number=%s";
	public static final String DUPLICATED_LOTTO_NUMBER = ERROR_PREFIX + "중복된 로또 숫자가 존재합니다. numbers=%s";

	private ErrorMessage() {}
}
