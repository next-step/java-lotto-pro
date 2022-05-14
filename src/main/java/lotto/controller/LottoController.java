package lotto.controller;

import lotto.*;
import lotto.view.LottoView;

public class LottoController {
	private static final LottoView view = new LottoView();

	public static void main(String[] args) {
		LottoCharge charge = LottoCharge.from(view.inputCharge());
		Lottos lottos = Lottos.buy(charge);
		view.showLottos(lottos);
		Answer answer = new Answer(view.inputAnswer());
		Winnings winnings = lottos.winnigs(answer);
		Statistics statistics = Statistics.of(charge, winnings);
		view.showStatistics(statistics);
	}
}
