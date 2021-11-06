package controller;

import model.LottoPapers;
import model.common.Income;
import model.common.LottoRule;
import model.common.Money;
import model.common.Range;
import model.common.Score;
import model.common.string.StringDelimiters;
import model.common.string.StringSeparator;
import model.generator.RandomLottoMachine;
import model.generator.WinnerLottoGenerator;
import model.store.LottoStore;
import view.IncomeView;
import view.InputView;
import view.LottoPapersView;
import view.ScoreView;

public final class LottoGame {

	private static final LottoGame LOTTO_GAME = new LottoGame();

	private static final Money LOTTO_PRICE = Money.from(1_000);
	private static final LottoRule LOTTO_RULE = LottoRule.of(Range.of(1, 45), 6);

	private static final IncomeView incomeView = IncomeView.from(System.out);
	private static final LottoPapersView lottoView = LottoPapersView.from(System.out);
	private static final ScoreView scoreView = ScoreView.from(System.out);

	private LottoGame() {
	}

	public static LottoGame instance() {
		return LOTTO_GAME;
	}

	public void play() {
		LottoPapers lottoPapers = LottoStore.of(
			Money.from(InputView.inputPurchaseAmount()),
			LOTTO_PRICE,
			RandomLottoMachine.from(LOTTO_RULE)
		).lottoPapers();

		lottoView.view(lottoPapers);

		Score score = lottoPapers.score(
			WinnerLottoGenerator.of(
				StringSeparator.of(InputView.inputWinningNumber(), StringDelimiters.of(",")),
				InputView.inputBonusBall(),
				LOTTO_RULE
			).lotto()
		);

		scoreView.view(score);
		incomeView.view(Income.of(LOTTO_PRICE, lottoPapers.size(), score.prizeMoney()));
	}
}
