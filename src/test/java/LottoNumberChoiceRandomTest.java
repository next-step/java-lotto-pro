import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoNumber;
import model.LottoNumberChoiceRandom;

public class LottoNumberChoiceRandomTest {
	@Test
	@DisplayName("랜덤으로 6개의 숫자 출력")
	void test_choose1() {
		List<LottoNumber> numbers1 = new LottoNumberChoiceRandom()
			.choose();
		List<LottoNumber> numbers2 = new LottoNumberChoiceRandom()
			.choose();

		assertThat(numbers1).isNotEqualTo(numbers2);
	}
}
