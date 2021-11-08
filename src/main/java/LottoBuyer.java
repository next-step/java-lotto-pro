import java.util.Collections;
import java.util.List;

public class LottoBuyer {

	private final LottoStore store;
	private final View view;

	public LottoBuyer(LottoStore lottoStore) {
		this.store = lottoStore;
		this.view = new View();
	}

	public List<Lotto> buy() {
		final LottoPayment payment = tryPay();
		view.space();

		final ManualLottoAmount manualLottoAmount = tryTellManualLottoAmount(payment);
		view.space();

		final List<Lotto> lottos = tryBuy(payment, manualLottoAmount);
		view.outBoughtLottos(manualLottoAmount, lottos);
		return lottos;
	}

	private LottoPayment tryPay() {
		LottoPayment payment;
		do {
			payment = pay(view.inPayKRW());
		} while (null == payment);
		return payment;
	}

	private LottoPayment pay(String s) {
		try {
			return LottoPayment.from(s);
		} catch(LottoPaymentFormatException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private ManualLottoAmount tryTellManualLottoAmount(LottoPayment payment) {
		ManualLottoAmount manualLottoAmount;
		do {
			manualLottoAmount = tellManualLottoAmount(payment, view.inManualLottoAmount());
		} while (null == manualLottoAmount);
		return manualLottoAmount;
	}

	private ManualLottoAmount tellManualLottoAmount(LottoPayment payment, String s) {
		try {
			return ManualLottoAmount.from(payment, s);
		} catch (ManualLottoAmountException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private List<Lotto> tryBuy(LottoPayment payment, ManualLottoAmount manualLottoAmount) {
		List<Lotto> lottos;
		do {
			final List<String> manualLottos = writeManualLottos(manualLottoAmount);
			lottos = buyLottos(payment, manualLottos);
		} while (null == lottos);
		return lottos;
	}

	private List<String> writeManualLottos(ManualLottoAmount manualLottoAmount) {
		if (manualLottoAmount.isBiggerThan(0)) {
			return view.inManualLottos(manualLottoAmount);
		}
		return Collections.emptyList();
	}

	private List<Lotto> buyLottos(LottoPayment payment, List<String> manualLottos) {
		try {
			return store.sell(payment, manualLottos);
		} catch (IllegalArgumentException e) {
			view.error(e.getMessage());
			return null;
		}
	}
}
