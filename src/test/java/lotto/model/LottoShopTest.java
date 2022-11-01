package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import lotto.strategy.LottoRandomCreateStrategy;

class LottoShopTest {

	@Test
	void 제공한_금액만큼_로또를_제공한다() {
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buy(new Money(14000));

		assertThat(lottos.countByType(LottoType.AUTO)).isEqualTo(14);
	}

	@Test
	void 수동_로또_구매시_수동_로또분을_포함한다() {
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buyManually(new Money(14000), new Lottos(
			Arrays.asList(
				new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6), LottoType.MANUAL),
				new Lotto(LottoNumber.of(2, 3, 4, 5, 6, 7), LottoType.MANUAL)
			)
		));

		assertThat(lottos.countByType(LottoType.MANUAL)).isEqualTo(2);
	}

}
