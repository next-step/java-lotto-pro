package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

	@Test
	@DisplayName("Lottos 생성 테스트")
	void create() {
		Lottos lottos1 = new Lottos(Arrays.asList(
			new Lotto(new LottoNumbers(3,6,23,24,32,33)),
			new Lotto(new LottoNumbers(5,7,13,34,36,37)),
			new Lotto(new LottoNumbers(13,16,17,22,31,34))
		));

		Lottos lottos2 = new Lottos(Arrays.asList(
			new Lotto(new LottoNumbers(3,6,23,24,32,33)),
			new Lotto(new LottoNumbers(5,7,13,34,36,37)),
			new Lotto(new LottoNumbers(13,16,17,22,31,34))
		));
		assertThat(lottos1).isEqualTo(lottos2);
	}

	@Test
	@DisplayName("로또 개수 반환 테스트")
	void count() {
		Lottos lottos1 = new Lottos(Arrays.asList(
			new Lotto(new LottoNumbers(3,6,23,24,32,33)),
			new Lotto(new LottoNumbers(5,7,13,34,36,37)),
			new Lotto(new LottoNumbers(13,16,17,22,31,34))
		));

		Lottos lottos2 = new Lottos(5);

		int result1 = lottos1.size();
		int result2 = lottos2.size();

		assertThat(result1).isEqualTo(3);
		assertThat(result2).isEqualTo(5);
	}
}
