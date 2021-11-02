package calculator;

public enum ErrorMessage {

	PARSE_NUMBER_ERROR("양수 또는 0이어야 합니다"),
	CUSTOM_SPLIT_ERROR("커스텀 구분자가 아닙니다");

	private String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String message() {
		return this.message;
	}

}
