package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Lotto;
import lotto.model.Numbers;
import lotto.util.LottoGenerator;

public class LottoTest {
	@Test
	@DisplayName("Lotto 무작위 생성 테스트")
	void autoGenerate() {
		Lotto lotto = LottoGenerator.generateAuto();
		assertThat(lotto).isNotNull();
	}

	@Test
	@DisplayName("Lotto 생성 테스트")
	void generate() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("Lotto 2개의 번호 비교 테스트")
	void compare() {
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
		assertThat(lotto.compareNumbers(winLotto)).isEqualTo(new Numbers(Arrays.asList(4, 5, 6)));
	}
}
