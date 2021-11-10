package lotto.code;

public enum ErrorCode {
	OUT_OF_LOTTO_NUMBER_RANGE_ERROR("ERR01", "로또 번호는 1~45까지 수만 입력 가능합니다."),
	INVALID_INPUT_NULL_VALUE_ERROR("ERR02", "빈 값은 입력 불가능합니다."),
	INVALID_INPUT_NUMBER_ERROR("ERR03", "숫자만 입력 가능합니다."),
	IS_NOT_LOTTO_NUMBER_SIZE_ERROR("ERR04", "6자리의 로또 번호를 입력해주세요."),
	LOTTO_NUMBER_DUPLICATE_ERROR("ERR06", "로또 번호 중 중복된 번호가 존재합니다."),
	UNDER_LOTTO_PRICE_ERROR("ERR07", "로또를 구입하기 위해선 1000원 이상의 금액이 필요합니다."),
	BONUS_NUMBER_DUPLICATE_ERROR("ERR08", "보너스번호는 로또번호와 중복될 수 없습니다."),
	NEGATIVE_AMOUNT_ERROR("ERR09", "입력 갯수는 1이상의 정수만 가능합니다."),
	INVALID_MONEY_INPUT_NUMBER_SIZE_ERROR("ERR10", "금액이 수동 입력 갯수보다 적습니다."),
	INVALID_INPUT_SIZE_INPUT_LIST_SIZE_ERROR("ERR11", "수동 로또 갯수와 입력된 수동 로또의 갯수가 다릅니다.");

	private final String errorCode;
	private final String errorMessage;

	ErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
