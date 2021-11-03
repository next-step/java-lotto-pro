public class LottoStorePaymentException extends RuntimeException {

	public static final String ERROR_NOT_ENOUGH_KRW = String.format(
		"지불 금액이 부족해요.(로또 장당 %d%s)"
		, Lotto.PRICE_KRW
		, LottoStore.KRW_UNIT
	);

	public LottoStorePaymentException() {
		super(ERROR_NOT_ENOUGH_KRW);
	}
}
