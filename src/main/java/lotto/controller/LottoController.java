package lotto.controller;

import static lotto.constant.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoCount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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
		LottoCount purchasedCount = calculatePurchasedLottoCount(money);
		LottoCount customLottoCount = inputView.inputCustomLottoCount(purchasedCount);

		Lottos lottos = purchaseLottos(purchasedCount);
		LottoNumbers lastWinningNumbers = LottoNumbers.of(inputView.inputWinningNumbers());
		LottoNumber bonusNumber = inputView.inputBonusNumber(lastWinningNumbers);

		WinningStatistics winningStatistics = WinningStatistics.createBy(lottos, lastWinningNumbers, bonusNumber, money);
		winningStatistics.buildStatistics();

		this.resultView.printWinningStatistics(winningStatistics);
	}

	public Lottos purchaseLottos(LottoCount purchasedCount) {
		List<Lotto> lottos = new ArrayList<>();
		lottos.addAll(createAutoLottos(purchasedCount));

		Lottos totalLottos = Lottos.of(lottos);
		this.resultView.printLottos(totalLottos);

		return totalLottos;
	}

	private LottoCount calculatePurchasedLottoCount(Money money) {
		return LottoCount.of(money.getValue() / LOTTO_PRICE);
	}

	private List<Lotto> createAutoLottos(LottoCount purchasedCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < purchasedCount.getValue(); i++) {
			LottoNumbers lottoNumbers = LottoNumbers.createBy(new LottoNumberGenerator());
			lottos.add(Lotto.of(lottoNumbers));
		}

		return lottos;
	}
}
