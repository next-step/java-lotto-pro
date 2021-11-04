public class LottoNumberFormatException extends IllegalArgumentException {

	public final static String ERROR_MESSAGE = String.format(
		"로또 번호는 %d부터 %d까지의 정수 중 하나여야 합니다."
		, LottoNumber.MIN_INCLUSIVE_NUMBER
		, LottoNumber.MAX_INCLUSIVE_NUMBER
	);

	public LottoNumberFormatException() {
		super(ERROR_MESSAGE);
	}
}
