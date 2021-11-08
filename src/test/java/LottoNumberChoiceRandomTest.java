import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoNumberChoiceRandom;
import model.LottoNumbers;

public class LottoNumberChoiceRandomTest {
	@Test
	@DisplayName("랜덤으로 6개의 숫자 출력")
	void test_choose1() {
		LottoNumbers numbers1 = new LottoNumberChoiceRandom()
			.choose();
		LottoNumbers numbers2 = new LottoNumberChoiceRandom()
			.choose();

		assertThat(numbers1).isNotEqualTo(numbers2);
	}
}
