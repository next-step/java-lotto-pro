public class LottoStoreSellException extends IllegalArgumentException {

	public static final String ERROR_MESSAGE = "로또 판매가 불가합니다.";

	public LottoStoreSellException() {
		super(ERROR_MESSAGE);
	}
}
