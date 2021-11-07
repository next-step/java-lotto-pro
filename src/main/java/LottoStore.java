import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

	public static final String KRW_UNIT = "원";

	public List<Lotto> sell(String pay, List<String> manualLottos) {
		final int paidKRW = parsePaidKRW(pay);
		validatePayment(paidKRW, manualLottos);

		final List<Lotto> lottosManually = sellManually(manualLottos);
		final List<Lotto> lottosAuto = sellAuto(paidKRW, lottosManually);

		return Stream.of(lottosManually, lottosAuto)
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}

	private int parsePaidKRW(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw new LottoStorePaymentException();
		}
	}

	private void validatePayment(int paidKRW, List<String> manualLottos) {
		if (paidKRW < Lotto.PRICE_KRW) {
			throw new LottoStorePaymentException();
		}
		final int numOfLottosCanBeSold = paidKRW / Lotto.PRICE_KRW;
		if (numOfLottosCanBeSold < manualLottos.size()) {
			throw new LottoStorePaymentException();
		}
	}

	private List<Lotto> sellManually(List<String> lottos) {
		return lottos.stream()
			.map(LottoFactory::from)
			.collect(Collectors.toList());
	}

	private List<Lotto> sellAuto(int paidKRW, List<Lotto> lottosManually) {
		final int numOfLottosCanBeSold = paidKRW / Lotto.PRICE_KRW;
		final int numOfLottosAuto = numOfLottosCanBeSold - lottosManually.size();
		return Stream.iterate(1, num -> num + 1)
			.limit(numOfLottosAuto)
			.map(num -> LottoFactory.of())
			.collect(Collectors.toList());
	}
}
