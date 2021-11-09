package step3.view.exception;

public class EnterNumberIsRangeSixException extends RuntimeException {

	public EnterNumberIsRangeSixException() {
		super("[ERROR] 숫자는 6개를 입력해야합니다.");
	}
}
