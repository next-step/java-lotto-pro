public class WinningLottoFormatException extends IllegalArgumentException {

	public final static String ERROR_MESSAGE = "당첨 번호와 보너스 번호는 서로 다른 수로 이루어져야 합나다.";

	public WinningLottoFormatException() {
		super(ERROR_MESSAGE);
	}
}
