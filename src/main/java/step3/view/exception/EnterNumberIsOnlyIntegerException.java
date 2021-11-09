package step3.view.exception;

public class EnterNumberIsOnlyIntegerException extends RuntimeException {
	public EnterNumberIsOnlyIntegerException() {
		super("[ERROR] 정수만을 입력해야합니다.");
	}
}
