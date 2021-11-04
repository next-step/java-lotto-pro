package controller;

import model.Income;
import model.LottoRule;
import model.LottoStore;
import model.Lottos;
import model.Money;
import model.RandomLottoMachine;
import model.Score;
import model.Seller;
import model.StringSeparator;
import model.WinnerLottoGenerator;
import view.IncomeView;
import view.InputView;
import view.LottosView;
import view.ScoreView;

public final class LottoGame {

	private static final IncomeView INCOME_VIEW = IncomeView.from(System.out);
	private static final LottosView LOTTO_VIEW = LottosView.from(System.out);
	private static final ScoreView SCORE_VIEW = ScoreView.from(System.out);

	private final Money lottoPrice;
	private final LottoRule rule;

	private LottoGame(int lottoPrice, LottoRule rule) {
		validate(rule);
		this.lottoPrice = Money.from(lottoPrice);
		this.rule = rule;
	}

	public static LottoGame from(int lottoPrice, LottoRule rule) {
		return new LottoGame(lottoPrice, rule);
	}

	public void play() {
		Lottos lottos = LottoStore.of(
			Money.from(InputView.inputPurchaseAmount()),
			Seller.of(lottoPrice, RandomLottoMachine.from(rule))
		).lottos();

		LOTTO_VIEW.view(lottos);

		Score score = lottos.score(
			WinnerLottoGenerator.of(
				StringSeparator.of(InputView.inputWinningNumber(), ","), rule));

		SCORE_VIEW.view(score);
		INCOME_VIEW.view(Income.of(lottoPrice, lottos.size(), score.prizeMoney()));
	}

	private void validate(LottoRule rule) {
		if (rule == null) {
			throw new IllegalArgumentException("'rule' must not be null");
		}
	}
}
