package exception;

public enum ErrorMessages {
	INPUT_NUMBER_FORMAT_NOT_VALID("숫자만 입력가능 합니다."),
	INPUT_INVESTMENT_MIN_VALID("1000원 이상 입력해야 합니다."),
	INPUT_INVESTMENT_UNIT_VALID("1000원 단위로 입력해야 합니다."),
	POSITIVE_NUMBER_FORMAT_NOT_VALID("양의 숫자만 입력가능 합니다."),
	INPUT_LOTTO_RANGE_NOT_VALID("1~45 까지의 숫자만 입력 가능합니다."),
	INPUT_NUMBER_COMMA_FORMAT_NOT_VALID("숫자와 ','만 입력 가능합니다."),
	INPUT_NUMBER_LENGTH_NOT_VALID("6개의 숫자를 입력해야 합니다."),
	INPUT_NUMBER_DUPLICATE("중복된 숫자가 존재합니다."),
	;

	private String values;

	ErrorMessages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
