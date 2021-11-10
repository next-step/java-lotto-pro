package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.ManualNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStore {

	public static final int INDEX_MIN = 0;
	private final LottoMachine lottoMachine;

	public LottoStore() {
		lottoMachine = new LottoMachine();
	}

	public void start() {
		Buyer buyer = purchasing();

		ResultView.printLottoPurchaseQuantity(buyer);

		Lottos userLottos = buyingLotto(buyer);

		WinningLotto winningLotto = getLastWeekWinningLotto();
		WinningRecord winningRecord = winningLotto.match(userLottos);

		double profitRate = winningRecord.profitRate(buyer.getAmount());
		ResultView.printWinningStat(winningRecord, profitRate);
	}

	private Buyer purchasing() {
		PurchaseAmount purchaseAmount = pay();
		ManualNumber manualNumber = getManualNumber();
		Lottos manualLottos = getManualLottos(manualNumber.getManualNumber());

		return new Buyer(purchaseAmount, manualNumber, manualLottos);
	}

	private PurchaseAmount pay() {
		try {
			return new PurchaseAmount(InputView.inputPurchaseAmount());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return pay();
		}
	}

	private ManualNumber getManualNumber() {
		try {
			return new ManualNumber(InputView.inputManualNumber());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return getManualNumber();
		}
	}

	private Lottos getManualLottos(int manualNumber) {
		ResultView.printManualLottosInfo();
		return IntStream.range(INDEX_MIN, manualNumber)
			.mapToObj(lotto -> generateManualLotto())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}

	private Lotto generateManualLotto() {
		try {
			return new Lotto(InputView.inputManualNumbers()
				.stream()
				.map(LottoNumber::of)
				.collect(Collectors.toSet()));
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return generateManualLotto();
		}
	}

	private WinningLotto getLastWeekWinningLotto() {
		try {
			return new WinningLotto(generateWinningLotto(), generateBonusNumber());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return getLastWeekWinningLotto();
		}
	}

	private LottoNumber generateBonusNumber() {
		return LottoNumber.of(InputView.inputBonusNumber());
	}

	private Lotto generateWinningLotto() {
		return new Lotto(InputView.inputLastWeekLottoNumber()
			.stream()
			.map(LottoNumber::of)
			.collect(Collectors.toSet()));
	}

	private Lottos buyingLotto(Buyer buyer) {
		Lottos lottos = lottoMachine.generateLottos(buyer);
		ResultView.printLottos(lottos);
		return lottos;
	}
}
