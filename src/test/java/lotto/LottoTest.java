package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

	@Test
	@DisplayName("로또 번호 6개 자동 생성 성공")
	public void lotto_auto_generated() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getNumbers().size()).isEqualTo(6);
		System.out.println(lotto.getNumbers());
	}

}