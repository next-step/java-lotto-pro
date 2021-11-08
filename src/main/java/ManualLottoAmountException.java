public class ManualLottoAmountException extends IllegalArgumentException {

	public final static String ERROR_MESSAGE_FORMAT = "로또(수동) 갯수는 0 <= n <= %d 범위여야 합니다.";
	public final static String ERROR_MESSAGE_NOT_FOUND_PAYMENT = "결제 방식을 찾을 수 없습니다.";

	public ManualLottoAmountException() {
		this(null);
	}

	public ManualLottoAmountException(LottoPayment payment) {
		super(message(payment));
	}

	private static String message(LottoPayment payment) {
		if (null == payment) {
			return ERROR_MESSAGE_NOT_FOUND_PAYMENT;
		}
		return String.format(ERROR_MESSAGE_FORMAT, payment.getNumOfLottosCanBuy());
	}
}
