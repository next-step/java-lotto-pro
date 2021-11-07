package lotto.code;

public enum ErrorCode {
	OUT_OF_LOTTO_NUMBER_RANGE_ERROR("ERR01", "로또 번호는 1~45까지 수만 입력 가능합니다."),
	INVALID_INPUT_NULL_VALUE_ERROR("ERR02", "빈 값은 입력 불가능합니다."),
	INVALID_INPUT_NUMBER_ERROR("ERR03", "숫자만 입력 가능합니다."),
	IS_NOT_LOTTO_NUMBER_SIZE_ERROR("ERR04", "6자리의 로또 번호를 입력해주세요."),
	LOTTO_NUMBER_DUPLICATE_ERROR("ERR06", "로또 번호 중 중복된 번호가 존재합니다."),
	UNDER_LOTTO_PRICE_ERROR("ERR07", "로또를 구입하기 위해선 1000원 이상의 금액이 필요합니다.");

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
