package lotto.controller;

import static lotto.constant.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.generator.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
	private final InputView inputView;
	private final ResultView resultView;

	public LottoController() {
		this.inputView = new InputView();
		this.resultView = new ResultView();
	}

	public void play() {
		Money money = inputView.inputMoney();
		Lottos lottos = purchaseLottos(money);
		LottoNumbers lastWinningNumbers = LottoNumbers.of(inputView.inputWinningNumbers());

		WinningStatistics winningStatistics = WinningStatistics.createBy(lottos, lastWinningNumbers, money);
		winningStatistics.buildStatistics();

		this.resultView.printWinningStatistics(winningStatistics);
	}

	public Lottos purchaseLottos(Money money) {
		int purchasedCount = calculatePurchasedLottoCount(money);
		Lottos lottos = Lottos.of(createLottos(purchasedCount));
		this.resultView.printLottos(lottos);

		return lottos;
	}

	private int calculatePurchasedLottoCount(Money money) {
		return money.getValue() / LOTTO_PRICE;
	}

	private List<Lotto> createLottos(int purchasedCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < purchasedCount; i++) {
			LottoNumbers lottoNumbers = LottoNumbers.createBy(new LottoNumberGenerator());
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}
}
