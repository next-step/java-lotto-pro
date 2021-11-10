package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {

	@Test
	@DisplayName("로또 자동 판매 테스트")
	public void LottoShopSellTest() {
		//given
		//when
		Lottos lottos = LottoShop.sell(new Money(3000));
		//then
		assertThat(lottos.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("로또 자동 판매 및 중복 없이 생성되는지 확인 테스트")
	public void LottoShopSellDuplicateTest() {
		//given
		Lottos lottos = LottoShop.sell(new Money(1000));
		//when
		HashSet<LottoNumber> duplicateCheck = new HashSet<>(lottos.getLottos().get(0).getLottoNumbers());
		//then
		assertThat(duplicateCheck).hasSize(6);
	}
}