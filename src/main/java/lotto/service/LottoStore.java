package lotto.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStore {

	private final LottoMachine lottoMachine;

	public LottoStore() {
		lottoMachine = new LottoMachine();
	}

	public void start() {
		PurchaseAmount purchaseAmount = pay();
		ResultView.printLottoPurchaseQuantity(purchaseAmount.getPurchaseQuantity());

		Lottos userLottos = buyingLotto(purchaseAmount.getPurchaseQuantity());

		WinningLotto winningLotto = getLastWeekWinningLotto();
		WinningRecord winningRecord = getWinngRecord(winningLotto, userLottos);

		double profitRate = winningRecord.profitRate(purchaseAmount.getAmount());
		ResultView.printWinningStat(winningRecord, profitRate);
	}

	private WinningRecord getWinngRecord(WinningLotto winningLotto, Lottos userLottos) {
		try {
			return winningLotto.match(userLottos);
		} catch (IllegalArgumentException e) {
			return getWinngRecord(winningLotto, userLottos);
		}
	}

	private PurchaseAmount pay() {
		try {
			return new PurchaseAmount(InputView.inputPurchaseAmount());
		} catch (IllegalArgumentException e) {
			return pay();
		}
	}

	private WinningLotto getLastWeekWinningLotto() {
		try {
			return new WinningLotto(generateWinningLotto(), generateBonusNumber());
		} catch (IllegalArgumentException e) {
			return getLastWeekWinningLotto();
		}
	}

	private LottoNumber generateBonusNumber() {
		return new LottoNumber(InputView.inputBonusNumber());
	}

	private Lotto generateWinningLotto() {
		return new Lotto(Arrays.stream(InputView.inputLastWeekLottoNumber())
			.map(Integer::valueOf)
			.map(LottoNumber::new)
			.collect(Collectors.toSet()));
	}

	private Lottos buyingLotto(int purchaseQuantity) {
		Lottos lottos = lottoMachine.generateLottos(purchaseQuantity);
		ResultView.printLottos(lottos);
		return lottos;
	}
}
