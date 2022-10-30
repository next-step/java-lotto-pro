package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.strategy.LottoRandomCreateStrategy;

class LottoShopTest {

	@Test
	void 제공한_금액만큼_로또를_제공한다() {
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buy(new Money(14000));

		assertThat(lottos.size()).isEqualTo(14);
	}

}
