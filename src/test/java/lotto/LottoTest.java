package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	public void 중복되지_않은_로또_번호_6_개_자동_생성() {
	    Lotto lotto = new Lotto();
	    assertThat(lotto.size()).isEqualTo(6);
		System.out.println(lotto);
	}
}
