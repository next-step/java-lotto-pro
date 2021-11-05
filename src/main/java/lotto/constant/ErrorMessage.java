package lotto.constant;

public class ErrorMessage {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static final String INVALID_LOTTO_NUMBER = ERROR_PREFIX + "로또 숫자는 1~45 사이의 숫자이어야 합니다. number=%s";
	public static final String DUPLICATED_LOTTO_NUMBER = ERROR_PREFIX + "중복된 로또 숫자가 존재합니다. numbers=%s";
	public static final String INVALID_INPUT_MONEY = ERROR_PREFIX + "구매금액이 올바르지 않습니다. money=%s";
	public static final String INVALID_INPUT_WINNING_NUMBERS = ERROR_PREFIX + "지난주 당첨번호가 올바르지 않습니다. numbers=%s";
	public static final String INVALID_INPUT_BONUS_NUMBER = ERROR_PREFIX + "보너스 볼 숫자가 올바르지 않습니다. number=%s";

	private ErrorMessage() {}
}
