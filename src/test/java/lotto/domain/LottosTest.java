package lotto.domain;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("로또 결과 생성 여부 테스트")
	public void LottosRuesltTest() {
		//given
		Lottos lottos = LottoShop.sell(new Money(5000));
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 9);
		//when
		int count = lottos.createLottoResult(winningLotto).countLotto();
		//then
		assertThat(count).isEqualTo(5);
	}

	@Test
	@DisplayName("로또 합치기 테스트")
	public void addAllTest() {
		//given
		//when
		Lottos lottos = LottoShop.sell(new Money(5000));
		Lottos otherLottos = LottoShop.sell(new Money(3000));
		//then
		assertThat(lottos.addAll(otherLottos).size()).isEqualTo(8);
	}

}

