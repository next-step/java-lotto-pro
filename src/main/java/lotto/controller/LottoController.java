package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoShop;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Ranks;
import lotto.model.Winner;
import lotto.strategy.LottoRandomCreateStrategy;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

	public static void main(String[] args) {
		Money payment = Input.inputPayment();

		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buyManually(payment, Input.inputManualLottos());

		Output.printLottos(lottos);

		Lotto winnerLotto = Input.inputWinnerLotto();
		LottoNumber bonusNumber = Input.inputBonusNumber();
		Ranks ranks = lottos.match(new Winner(winnerLotto, bonusNumber));

		Output.printResult(ranks);
	}
}
