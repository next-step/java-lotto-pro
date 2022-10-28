package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Ranks;
import lotto.strategy.LottoCreateStrategy;
import lotto.strategy.LottoRandomCreateStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
	private static final Money LOTTO_PRICE = new Money(1000L);
	private static final LottoCreateStrategy LOTTO_CREATE_STRATEGY = new LottoRandomCreateStrategy();

	public static void main(String[] args) {
		Money payment = Input.inputPayment();
		Lottos lottos = getLottos(payment);

		Output.printLottos(lottos);

		Lotto winnerLotto = Input.inputWinnerLotto();
		Ranks ranks = lottos.match(winnerLotto);

		Output.printResult(ranks, payment);
	}

	private static Lottos getLottos(final Money payment) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < payment.calculateQuantity(LOTTO_PRICE); i++) {
			lottoList.add(LOTTO_CREATE_STRATEGY.create());
		}
		return new Lottos(lottoList);
	}

}
