public class LottoPayment {

	public static final String KRW_UNIT = "원";

	private final int numOfLottosCanBuy;

	private LottoPayment(int KRW) {
		validate(KRW);
		this.numOfLottosCanBuy = KRW / Lotto.PRICE_KRW;
	}

	private void validate(int KRW) {
		if (KRW < Lotto.PRICE_KRW) {
			throw new LottoPaymentFormatException();
		}
	}

	public boolean canBuy(int numberOfLottos) {
		return numberOfLottos <= numOfLottosCanBuy;
	}

	public int getNumOfLottosCanBuy() {
		return numOfLottosCanBuy;
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
