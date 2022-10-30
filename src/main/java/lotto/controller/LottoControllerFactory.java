package lotto.controller;

import lotto.domain.AutoLottoTicketGenerator;
import lotto.domain.LottoVendor;
import money.Money;

public class LottoControllerFactory {

	private static final Money LOTTO_PRICE = Money.wons(1000);

	public static LottoController createLottoController() {
		return new LottoController(
			LOTTO_PRICE,
			new LottoVendor(LOTTO_PRICE, new AutoLottoTicketGenerator()));
	}
}
