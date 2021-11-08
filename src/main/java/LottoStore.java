import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

	public List<Lotto> sell(LottoPayment payment, List<String> manualLottos) {
		validate(payment, manualLottos);

		final List<Lotto> lottosManually = sellManually(manualLottos);
		final List<Lotto> lottosAuto = sellAuto(payment, lottosManually);

		return Stream.of(lottosManually, lottosAuto)
			.flatMap(Collection::stream)
			.collect(Collectors.toList());
	}

	private void validate(LottoPayment payment, List<String> manualLottos) {
		if (null == payment) {
			throw new LottoStoreSellException();
		}
		if (null == manualLottos) {
			throw new LottoStoreSellException();
		}
		if (!payment.canBuy(manualLottos.size())) {
			throw new LottoStoreSellException();
		}
	}

	private List<Lotto> sellManually(List<String> lottos) {
		return lottos.stream()
			.map(LottoFactory::from)
			.collect(Collectors.toList());
	}

	private List<Lotto> sellAuto(LottoPayment payment, List<Lotto> lottosManually) {
		final int numOfLottosCanBeSold = payment.getNumOfLottosCanBuy();
		final int numOfLottosAuto = numOfLottosCanBeSold - lottosManually.size();
		return Stream.iterate(1, num -> num + 1)
			.limit(numOfLottosAuto)
			.map(num -> LottoFactory.of())
			.collect(Collectors.toList());
	}
}
