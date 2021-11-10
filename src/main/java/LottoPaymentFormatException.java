public class LottoPaymentFormatException extends IllegalArgumentException {

	public static final String ERROR_MESSAGE = String.format(
		"지불 금액이 부족해요.(로또 장당 %d%s)"
		, Lotto.PRICE_KRW
		, LottoPayment.KRW_UNIT
	);

	public LottoPaymentFormatException() {
		super(ERROR_MESSAGE);
	}
}
