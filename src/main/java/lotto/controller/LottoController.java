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
		Lottos manualLottos = Input.inputManualLottos();

		Money moneyAfterBuyLotto = payment.minus(manualLottos.getTotalSpent());
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos auttoLottos = lottoShop.buy(moneyAfterBuyLotto);

		Lottos lottos = manualLottos.merge(auttoLottos);
		Output.printLottos(lottos);

		Lotto winnerLotto = Input.inputWinnerLotto();
		LottoNumber bonusNumber = Input.inputBonusNumber();
		Ranks ranks = lottos.match(new Winner(winnerLotto, bonusNumber));

		Output.printResult(ranks);
	}
}
