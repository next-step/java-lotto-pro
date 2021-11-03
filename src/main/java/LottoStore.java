import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

	public static final String KRW_UNIT = "원";

	public List<Lotto> sell(int paidKRW) {
		validatePayment(paidKRW);
		final int numOfLottos = paidKRW / Lotto.PRICE_KRW;
		return Stream.iterate(1, num -> num + 1)
			.limit(numOfLottos)
			.map((num) -> Lotto.of())
			.collect(Collectors.toList());
	}

	private void validatePayment(int paidKRW) {
		if (paidKRW < Lotto.PRICE_KRW) {
			throw new LottoStorePaymentException();
		}
	}
}
