package lotto.domain;

import lotto.view.Customer;

public class LottoInvest {
	public LottoInvest() {
		LottoOrder order = Customer.askOrder();
	}
}
