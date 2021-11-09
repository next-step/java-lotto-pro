package step3.view.exception;

public class LastCommaException extends RuntimeException {
	public LastCommaException() {
		super("[ERROR] ,를 마지막에 입력하면 안됩니다.");
	}
}
