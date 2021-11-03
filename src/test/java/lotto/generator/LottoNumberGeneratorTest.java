package lotto.generator;

import static lotto.constant.LottoNumberConstant.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

	@DisplayName("랜덤하게 생성된 숫자의 개수는 항상 6개 이다.")
	@Test
	void generateRandomNumbers1() {
		// given
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

		// when
		List<Integer> numbers = lottoNumberGenerator.generate();

		// then
		assertThat(numbers.size()).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
	}

	@DisplayName("랜덤하게 생성된 숫자는 서로 중복되지 않는다.")
	@Test
	void generateRandomNumbers2() {
		// given
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		List<Integer> numbers = lottoNumberGenerator.generate();

		// when
		Set<Integer> numberSet = new LinkedHashSet<>(numbers);

		// then
		assertThat(numbers.size()).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
		assertThat(numberSet.size()).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
		assertThat(numbers.size()).isEqualTo(numberSet.size());
	}

	@DisplayName("랜덤하게 생성된 숫자들은 항상 1 ~ 45 사이에 포함된다.")
	@Test
	void generateRandomNumbers3() {
		// given
		LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
		List<Integer> numbers = lottoNumberGenerator.generate();

		// when
		Integer min = Collections.min(numbers);
		Integer max = Collections.max(numbers);

		// then
		assertThat(min).isGreaterThanOrEqualTo(LOTTO_NUMBER_MIN);
		assertThat(max).isLessThanOrEqualTo(LOTTO_NUMBER_MAX);
	}
}