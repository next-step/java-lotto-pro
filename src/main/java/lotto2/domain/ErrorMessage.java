package lotto2.domain;

public enum ErrorMessage {

	ONLY_POSITIVE_NUMBER("0 이상의 양의 정수여야 합니다");

	private String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String value() {
		return this.message;
	}
	
}
