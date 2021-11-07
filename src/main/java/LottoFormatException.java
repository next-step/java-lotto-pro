public class LottoFormatException extends IllegalArgumentException {

	public final static String ERROR_MESSAGE = String.format(
		"로또는 서로 다른 %d가지 숫자로 이루어져야 합니다."
		, Lotto.NUM_OF_LOTTO_NUMBERS
	);

	public LottoFormatException() {
		super(ERROR_MESSAGE);
	}
}
