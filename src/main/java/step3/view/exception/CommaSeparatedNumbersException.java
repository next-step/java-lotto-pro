package step3.view.exception;

public class CommaSeparatedNumbersException extends RuntimeException {
	public CommaSeparatedNumbersException() {
		super("[ERROR] 숫자는 ,구분해서 입력해야합니다.");
	}
}
