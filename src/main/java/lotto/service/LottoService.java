package lotto.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoService {

	public static final int INDEX_MIN = 0;
	private final LottoStore lottoStore;

	public LottoService() {
		lottoStore = new LottoStore();
	}

	public void start() {
		PurchaseAmount purchaseAmount = pay();
		LottoQuantity lottoQuantity = getLottoQuantity(purchaseAmount.getPurchaseQuantity());
		Buyer buyer = new Buyer(purchaseAmount, buyLottos(lottoQuantity));

		ResultView.printLottoPurchaseQuantity(lottoQuantity);
		ResultView.printLottos(buyer.getLottos());

		WinningLotto winningLotto = getLastWeekWinningLotto();
		WinningRecord winningRecord = buyer.match(winningLotto);

		ResultView.printWinningStat(winningRecord, buyer.getAmount());
	}

	private Lottos buyLottos(LottoQuantity lottoQuantity) {
		return lottoStore.buyLottos(lottoQuantity.getAutoQuantity(), getManualLottos(lottoQuantity.getManualQuantity()));
	}

	private PurchaseAmount pay() {
		try {
			return new PurchaseAmount(InputView.inputPurchaseAmount());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return pay();
		}
	}

	private LottoQuantity getLottoQuantity(int purchaseQuantity) {
		try {
			return new LottoQuantity(purchaseQuantity, InputView.inputManualLottoQuantity());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return getLottoQuantity(purchaseQuantity);
		}
	}

	private Lottos getManualLottos(int manualNumber) {
		ResultView.printManualLottosInfo();
		return IntStream.range(INDEX_MIN, manualNumber)
			.mapToObj(lotto -> inputManualLotto())
			.collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
	}

	private Lotto inputManualLotto() {
		try {
			return lottoStore.generateLotto(InputView.inputManualNumbers());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return inputManualLotto();
		}
	}

	private WinningLotto getLastWeekWinningLotto() {
		try {
			return new WinningLotto(inputWinningLotto(), inputBonusNumber());
		} catch (IllegalArgumentException e) {
			ResultView.printErrorMsg(e.getMessage());
			return getLastWeekWinningLotto();
		}
	}

	private Lotto inputWinningLotto() {
		return lottoStore.generateLotto(InputView.inputLastWeekLottoNumber());
	}

	private LottoNumber inputBonusNumber() {
		return LottoNumber.of(InputView.inputBonusNumber());
	}
}
