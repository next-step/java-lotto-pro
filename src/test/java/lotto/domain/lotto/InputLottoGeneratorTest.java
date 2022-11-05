package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InputLottoGeneratorTest {
	@Test
	void 로또_번호_6개_입력() {
		assertThat(new InputLottoGenerator("1,2,3,4,5,6").generate())
			.isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));

	}
}
