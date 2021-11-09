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
		Lotto lotto = LottoShop.sell();
		//then
		assertThat(lotto.getLottoNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("로또 자동 판매 및 중복 없이 생성되는지 확인 테스트")
	public void LottoShopSellDuplicateTest() {
		//given
		Lotto lotto = LottoShop.sell();
		//when
		HashSet<Integer> duplicateCheck = new HashSet<>();
		for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
			duplicateCheck.add(lottoNumber.getValue());
		}
		//then
		assertThat(duplicateCheck).hasSize(6);
	}

	@Test
	@DisplayName("로또 수동 판매 테스트")
	public void LottoShopStringSellTest() {
		//given
		//when
		Lotto lotto = LottoShop.sell("1, 2, 3, 4, 5, 45");
		//then
		assertThat(lotto.getLottoNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("로또 수동 판매시 번호 중복 예외 테스트")
	public void LottoShopStringSellExceptionTest() {
		assertThatThrownBy(() -> LottoShop.sell("1, 2, 32, 32, 5, 45"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 중복 될 수 없습니다.");
	}
}