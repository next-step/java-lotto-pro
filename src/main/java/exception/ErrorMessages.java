package exception;

public enum ErrorMessages {
	INPUT_NUMBER_FORMAT_NOT_VALID("숫자만 입력가능 합니다."),
	INPUT_INVESTMENT_MIN_VALID("1000원 이상 입력해야 합니다."),
	INPUT_INVESTMENT_UNIT_VALID("1000원 단위로 입력해야 합니다.");

	private String values;

	ErrorMessages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
