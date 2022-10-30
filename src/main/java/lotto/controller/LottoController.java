package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Ranks;
import lotto.strategy.LottoRandomCreateStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

	public static void main(String[] args) {
		Money payment = Input.inputPayment();
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buy(payment);

		Output.printLottos(lottos);

		Lotto winnerLotto = Input.inputWinnerLotto();
		Ranks ranks = lottos.match(winnerLotto);

		Output.printResult(ranks, payment);
	}
}
