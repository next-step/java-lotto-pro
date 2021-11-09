public class LottoPayment {

	public static final String KRW_UNIT = "원";

	private final int krw;

	private LottoPayment(int krw) {
		validate(krw);
		this.krw = krw;
	}

	private void validate(int krw) {
		if (krw < Lotto.PRICE_KRW) {
			throw new LottoPaymentFormatException();
		}
	}

	public boolean canBuy(int numOfLottos) {
		return numOfLottos <= getNumOfLottosCanBuy();
	}

	public int getNumOfLottosCanBuy() {
		return krw / Lotto.PRICE_KRW;
	}

	public static LottoPayment from(String s) {
		return new LottoPayment(parse(s));
	}

	private static int parse(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new LottoPaymentFormatException();
		}
	}
}
