import java.util.Collections;
import java.util.List;

public class BuyLottosController {

	private final View view;

	public BuyLottosController(View view) {
		this.view = view;
	}

	public Lottos buyLottosAt(LottoStore store) {
		final LottoPayment payment = tryPay();
		view.space();

		final ManualLottoQuantity manualLottoQuantity = tryGetManualLottoQuantity(payment);
		view.space();

		final Lottos lottos = tryBuy(store, payment, manualLottoQuantity);
		view.outBoughtLottos(manualLottoQuantity, lottos);
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

	private ManualLottoQuantity tryGetManualLottoQuantity(LottoPayment payment) {
		ManualLottoQuantity manualLottoQuantity;
		do {
			manualLottoQuantity = getManualLottoQuentity(payment, view.inManualLottoQuantity());
		} while (null == manualLottoQuantity);
		return manualLottoQuantity;
	}

	private ManualLottoQuantity getManualLottoQuentity(LottoPayment payment, String s) {
		try {
			return ManualLottoQuantity.from(payment, s);
		} catch (ManualLottoQuantityException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private Lottos tryBuy(LottoStore store, LottoPayment payment, ManualLottoQuantity manualLottoQuantity) {
		Lottos lottos;
		do {
			final List<String> manualLottos = writeManualLottos(manualLottoQuantity);
			lottos = buyLottos(store, payment, manualLottos);
		} while (null == lottos);
		return lottos;
	}

	private List<String> writeManualLottos(ManualLottoQuantity manualLottoQuantity) {
		if (manualLottoQuantity.isBiggerThan(0)) {
			return view.inManualLottos(manualLottoQuantity);
		}
		return Collections.emptyList();
	}

	private Lottos buyLottos(LottoStore store, LottoPayment payment, List<String> manualLottos) {
		try {
			return store.sell(payment, manualLottos);
		} catch (IllegalArgumentException e) {
			view.error(e.getMessage());
			return null;
		}
	}
}
