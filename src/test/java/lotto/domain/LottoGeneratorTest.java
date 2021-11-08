package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
	@Test
	@DisplayName("로또 생성기는 이전과 완벽하게 동일한 로또를 생성하지 않는다.")
	public void testGenerateResult() {
		Lotto lotto1 = LottoGenerator.generate();
		Lotto lotto2 = LottoGenerator.generate();

		assertThat(lotto1.numbers()).isNotEqualTo(lotto2.numbers());
	}
}