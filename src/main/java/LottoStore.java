import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

	public static final String KRW_UNIT = "원";

	public List<Lotto> sell(String pay) {
		final int paidKRW = parsePaidKRW(pay);
		validatePayment(paidKRW);

		final int numOfLottos = paidKRW / Lotto.PRICE_KRW;
		return Stream.iterate(1, num -> num + 1)
			.limit(numOfLottos)
			.map(num -> LottoFactory.of())
			.collect(Collectors.toList());
	}

	private int parsePaidKRW(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new LottoStorePaymentException();
		}
	}

	private void validatePayment(int paidKRW) {
		if (paidKRW < Lotto.PRICE_KRW) {
			throw new LottoStorePaymentException();
		}
	}
}
