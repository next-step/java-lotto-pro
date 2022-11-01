package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.domain.amount.Amount;

class DefaultPurchaseStrategyTest {
	@Test
	void 로또_15000원어치_구매() {
		List<Lotto> lottos = new DefaultPurchaseStrategy(Amount.from(15000)).purchase();
		assertThat(lottos).hasSize(15);
	}
}
