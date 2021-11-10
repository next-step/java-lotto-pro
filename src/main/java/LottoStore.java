import java.util.List;

public class LottoStore {

	public Lottos sell(LottoPayment payment, List<String> manualLottos) {
		validate(payment, manualLottos);
		final Lottos lottosManually = LottosFactory.manuallyFrom(manualLottos);
		final Lottos lottosAuto = LottosFactory.autoFrom(payment, lottosManually);
		return Lottos.merge(lottosManually, lottosAuto);
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
}
