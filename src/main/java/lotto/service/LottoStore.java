package lotto.service;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Collectors;

import lotto.common.Calculator;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoStore {

	public static final String REGEX_DELIMITER = ",";
	private final InputView inputView;
	private final ResultView resultView;
	private final LottoMachine lottoMachine;

	public LottoStore() {
		inputView = new InputView();
		resultView = new ResultView();
		lottoMachine = new LottoMachine();
	}

	public void start() {
		PurchaseAmount purchaseAmount = pay();
		resultView.printLottoPurchaseQuantity(purchaseAmount.getPurchaseQuantity());

		Lottos userLottos = buyingLotto(purchaseAmount.getPurchaseQuantity());

		WinningLotto winningLotto = getLastWeekWinningLotto();
		WinningRecord winningRecord = winningLotto.match(userLottos);
		double profitRate = Calculator.profitRate(purchaseAmount.getAmount(), winningRecord.getRevenue());
		resultView.printWinningStat(winningRecord, profitRate);
	}

	private PurchaseAmount pay() {
		try {
			return new PurchaseAmount(Integer.parseInt(inputView.inputPurchaseAmount()));
		} catch (IllegalArgumentException e) {
			return pay();
		}
	}

	private WinningLotto getLastWeekWinningLotto() {
		try {
			return new WinningLotto(Arrays.stream(inputView.inputLastWeekLottoNumber().split(REGEX_DELIMITER))
				.map(Integer::valueOf)
				.collect(Collectors.toList()));
		} catch (IllegalArgumentException e) {
			return getLastWeekWinningLotto();
		}
	}

	private Lottos buyingLotto(int purchaseQuantity) {
		Lottos lottos = lottoMachine.generateLottos(purchaseQuantity);
		resultView.printLottos(lottos);
		return lottos;
	}
}
