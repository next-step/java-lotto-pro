package lotto.service;

import java.util.Arrays;
import java.util.stream.Collectors;

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
		WinningRecord winningRecord = winningLotto.match(userLottos);

		double profitRate = winningRecord.profitRate(purchaseAmount.getAmount(), winningRecord.getRevenue());
		ResultView.printWinningStat(winningRecord, profitRate);
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
			return new WinningLotto(Arrays.stream(InputView.inputLastWeekLottoNumber())
				.map(Integer::valueOf)
				.map(LottoNumber::new)
				.collect(Collectors.toSet()));
		} catch (IllegalArgumentException e) {
			return getLastWeekWinningLotto();
		}
	}

	private Lottos buyingLotto(int purchaseQuantity) {
		Lottos lottos = lottoMachine.generateLottos(purchaseQuantity);
		ResultView.printLottos(lottos);
		return lottos;
	}
}
