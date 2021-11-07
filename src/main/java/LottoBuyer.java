import java.util.Collections;
import java.util.List;

import step2.PositiveNumber;
import step2.PositiveNumberFormatException;

public class LottoBuyer {

	private final LottoStore store;
	private final View view;

	public LottoBuyer(LottoStore lottoStore) {
		this.store = lottoStore;
		this.view = new View();
	}

	public List<Lotto> buy() {
		int numOfManualLottos;
		List<Lotto> lottos;
		do {
			final String paidKRW = payKRW();
			final List<String> manualLottos = writeManualLottos();

			numOfManualLottos = manualLottos.size();
			lottos = buyLottos(paidKRW, manualLottos);
		} while (null == lottos);
		view.outBoughtLottos(numOfManualLottos, lottos);
		return lottos;
	}

	private String payKRW() {
		final String paidKRW = view.inPayKRW();
		view.space();
		return paidKRW;
	}

	private List<String> writeManualLottos() {
		final PositiveNumber numOfManualLottos = tryGetNumOfManualLottos();
		view.space();

		if (numOfManualLottos.get() > 0) {
			return view.inManualLottos(numOfManualLottos);
		}
		return Collections.emptyList();
	}

	private PositiveNumber tryGetNumOfManualLottos() {
		PositiveNumber numOfManualLottos;
		do {
			numOfManualLottos = getNumOfManualLottos(view.inNumOfManualLottos());
		} while (null == numOfManualLottos);
		return numOfManualLottos;
	}

	private PositiveNumber getNumOfManualLottos(String s) {
		try {
			return parseNumOfLottos(s);
		} catch (NumOfLottosFormatException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private List<Lotto> buyLottos(String pay, List<String> manualLottos) {
		try {
			return store.sell(pay, manualLottos);
		} catch (IllegalArgumentException e) {
			view.error(e.getMessage());
			return null;
		}
	}

	private PositiveNumber parseNumOfLottos(String s) {
		try {
			return PositiveNumber.from(s);
		} catch (PositiveNumberFormatException e) {
			throw new NumOfLottosFormatException();
		}
	}
}
