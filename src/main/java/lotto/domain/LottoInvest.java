package lotto.domain;

import lotto.domain.wrapper.LottoOrder;
import lotto.view.Customer;

public class LottoInvest {
	public LottoInvest() {
		LottoOrder order = Customer.askOrder();
	}
}
