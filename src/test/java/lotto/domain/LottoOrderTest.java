package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.wrapper.LottoOrderRequest;

public class LottoOrderTest {
	@DisplayName("로또 5장 구입 시 보유하게 된 로또 개수 검증")
	@Test
	void buyTicketsTest() {
		// given
		final int ORDER_COUNT = 5;

		// when
		LottoOrder lottoOrder = new LottoOrder();
		lottoOrder.buyTickets(LottoOrderRequest.byOrderCount(ORDER_COUNT));

		// then
		assertThat(lottoOrder.holdCount()).isEqualTo(ORDER_COUNT);
	}
}
