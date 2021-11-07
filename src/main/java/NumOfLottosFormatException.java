public class NumOfLottosFormatException extends IllegalArgumentException {

	public final static String ERROR_MESSAGE = "로또 갯수는 0보다 크거나 같아야 합니다.";

	public NumOfLottosFormatException() {
		super(ERROR_MESSAGE);
	}
}
