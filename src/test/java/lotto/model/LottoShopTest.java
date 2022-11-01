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

		assertThat(lottos.countAuto()).isEqualTo(14);
	}

	@Test
	void 수동_로또_구매시_수동_로또분을_포함한다() {
		LottoShop lottoShop = new LottoShop(new LottoRandomCreateStrategy());
		Lottos lottos = lottoShop.buyManually(new Money(14000), new Lottos(
			Arrays.asList(
				new ManualLotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
				new ManualLotto(LottoNumber.of(2, 3, 4, 5, 6, 7))
			)
		));

		assertThat(lottos.countManual()).isEqualTo(2L);
	}

}
