package controller;

import model.LottoPapers;
import model.common.Income;
import model.common.LottoRule;
import model.common.Money;
import model.common.Range;
import model.common.Score;
import model.common.StringNumberConverter;
import model.common.string.StringDelimiters;
import model.common.string.StringSeparator;
import model.generator.RandomLottoGenerator;
import model.generator.WinnerLottoGenerator;
import model.store.Customer;
import model.store.LottoMachine;
import model.store.LottoStore;
import view.IncomeView;
import view.InputView;
import view.LottoPapersView;
import view.ScoreView;

public final class LottoGame {

	private static final LottoGame LOTTO_GAME = new LottoGame();

	private static final Money LOTTO_PRICE = Money.from(1_000);
	private static final LottoRule LOTTO_RULE = LottoRule.of(Range.of(1, 45), 6);
	private static final StringNumberConverter NUMBERS_CONVERTER = StringNumberConverter.from(LOTTO_RULE);

	private static final IncomeView incomeView = IncomeView.from(System.out);
	private static final LottoPapersView lottoView = LottoPapersView.from(System.out);
	private static final ScoreView scoreView = ScoreView.from(System.out);
	private static final StringDelimiters NUMBER_DELIMITER = StringDelimiters.of(",");

	private LottoGame() {
	}

	public static LottoGame instance() {
		return LOTTO_GAME;
	}

	public void play() {
		LottoPapers lottoPapers = lottoStore().lottoPapers();

		lottoView.view(lottoPapers);

		Score score = lottoPapers.score(winnerLottoGenerator().lotto());
		scoreView.view(score);
		incomeView.view(Income.of(LOTTO_PRICE, lottoPapers.size(), score.prizeMoney()));
	}

	private LottoStore lottoStore() {
		return LottoStore.of(
			customer(),
			LOTTO_PRICE,
			lottoMachine()
		);
	}

	private WinnerLottoGenerator winnerLottoGenerator() {
		return WinnerLottoGenerator.of(
			NUMBERS_CONVERTER,
			StringSeparator.of(InputView.inputWinningNumber(), NUMBER_DELIMITER),
			InputView.inputBonusBall()
		);
	}

	private LottoMachine lottoMachine() {
		return LottoMachine.of(NUMBERS_CONVERTER, RandomLottoGenerator.from(LOTTO_RULE));
	}

	private Customer customer() {
		return Customer.of(
			Money.from(InputView.inputPurchaseAmount()),
			InputView.inputManualPurchaseNumbers(),
			NUMBER_DELIMITER
		);
	}
}
