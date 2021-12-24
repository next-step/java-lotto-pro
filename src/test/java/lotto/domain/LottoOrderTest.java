package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.wrapper.LottoOrderCount;
import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;

public class LottoOrderTest {

	@DisplayName("로또 5장 구입 시 투자금 검증")
	@Test
	void totalInvestmentTest() {
		// given
		final int ORDER_COUNT = 5;

		// when
		LottoOrder lottoOrder = new LottoOrder(new LottoOrderCount(ORDER_COUNT));

		// then
		assertThat(lottoOrder.totalInvestment()).isEqualTo(new Money(LottoTicket.PRICE * ORDER_COUNT));
	}

	@DisplayName("로또 5장 구입 시 보유하게 된 로또 개수 검증")
	@Test
	void buyTicketsTest() {
		// given
		final int ORDER_COUNT = 5;

		// when
		LottoOrder lottoOrder = new LottoOrder(new LottoOrderCount(ORDER_COUNT));

		// then
		assertThat(lottoOrder.holdCount()).isEqualTo(ORDER_COUNT);
	}
}
