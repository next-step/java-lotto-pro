package step3.lotto.exception;

public class DuplicationOrLessThenSixException extends RuntimeException {
	public DuplicationOrLessThenSixException() {
		super("중복된 숫자가 존재하거나 로또번호가 6개 미만입니다.");
	}
}
