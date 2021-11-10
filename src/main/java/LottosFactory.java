import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottosFactory {

	public static Lottos manuallyFrom(List<String> lottos) {
		return new Lottos(lottos.stream()
			.map(LottoFactory::from)
			.collect(Collectors.toList()));
	}

	public static Lottos autoFrom(LottoPayment payment, Lottos manualLottos) {
		final int numOfLottosCanBuy = payment.getNumOfLottosCanBuy();
		final int numOfLottosAuto = numOfLottosCanBuy - manualLottos.size();
		return new Lottos(Stream.iterate(1, num -> num + 1)
			.limit(numOfLottosAuto)
			.map(num -> LottoFactory.of())
			.collect(Collectors.toList()));
	}
}
